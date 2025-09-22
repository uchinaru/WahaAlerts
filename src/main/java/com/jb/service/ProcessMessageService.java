package com.jb.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import com.jb.builder.PromptBuilder;
import com.jb.config.PropertiesConfig;
import com.jb.enums.ModelosIA;
import com.jb.model.Despesas;
import com.jb.model.DTOJsonWaha;
import com.jb.model.Usuario;
import com.jb.repository.DespesasRepository;
import com.jb.repository.UserRepository;
import com.jb.utils.JsonUtils;

@Component
public class ProcessMessageService {
	
	@Autowired
	public DespesasRepository despesasRepository;
	
	@Autowired
	public UserRepository userRepository;
	
	@Autowired
	public PropertiesConfig propertiesFactory;
	
	public String mensagemAnterior ="";
	
	public int processaMensagem(String mensagem) {
		
		try {
			DTOJsonWaha mensagemModel = JsonUtils.transformJsonInObjectWaha(mensagem);
			
			Usuario user = userRepository.findByContato(mensagemModel.payload.from);
			
			if(!mensagemAnterior.equals(mensagemModel.payload.body)) {
				
				try {
					Client cliente = Client.builder().apiKey(propertiesFactory.getGeminiKey()).build();
					
					GenerateContentResponse response = cliente.models.generateContent(ModelosIA.GEMINI_FLASH_LITE.descricao, PromptBuilder.builder().message(mensagemModel.payload.body).getExpense(), null);
					
					String retorno = response.text();
					if ( !retorno.isEmpty() && !"Null".equals(retorno)) {
						
						try {
							String[] addDespesas = response.text().split("\\|");

							Despesas despesa = new Despesas();
							despesa.setItem(addDespesas[0]);
							despesa.setValor(addDespesas[1]);
							despesa.setCategoria(addDespesas[2]);
							despesa.setUserId(user.getId());
							despesa.setDataRegistro(new Date());
							despesasRepository.save(despesa);
							return 200;
						} catch (Exception e) {
							System.out.println("Error ao cadastrar despesa " + e);
						}
					}else {
						return 400;
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				mensagemAnterior = mensagemModel.payload.body;
			}
			
		} catch (Exception e) {
			System.out.println("Error ao obter mensagem" + e);
		}
		return 200;
	}
}
