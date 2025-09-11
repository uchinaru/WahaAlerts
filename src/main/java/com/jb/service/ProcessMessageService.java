package com.jb.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import com.jb.builder.PromptBuilder;
import com.jb.config.PropertiesConfig;
import com.jb.enums.ModelosIA;
import com.jb.enums.TiposConta;
import com.jb.model.Despesas;
import com.jb.model.JsonWahaModel;
import com.jb.model.Usuario;
import com.jb.repository.DespesasRepository;
import com.jb.repository.UserRepository;

@Service
public class ProcessMessageService {

	@Autowired
	public DespesasRepository despesasRepository;
	
	@Autowired
	public UserRepository userRepository;
	
	@Autowired
	public PropertiesConfig propertiesFactory;
	
	public String mensagemAnterior ="";
	
	public void processaMensagem(String mensagem) {
		
		try {
			ObjectMapper bjectMapper = new ObjectMapper();
			JsonWahaModel mensagemModel = bjectMapper.readValue(mensagem, JsonWahaModel.class);
			
			Usuario user = userRepository.findByContato(mensagemModel.payload.from);
			
			if(user == null && mensagemModel.payload.fromMe && !mensagemAnterior.equals(mensagemModel.payload.body)) {
				
				Usuario usuario = new Usuario();
				
				usuario.setContato(mensagemModel.payload.from);
				usuario.setNome(mensagemModel.payload._data.notifyName);
				usuario.setTipoConta(TiposConta.GRATUITO.descricao);
				
				userRepository.save(usuario);
//				sendSimpleMessage(mensagemModel.payload.from, "Cadastrado com sucesso, já pode fazer seus registros", mensagemModel.session);
				mensagemAnterior = "Cadastrado com sucesso !";
				
			}else if(user != null) {
				
				if(!mensagemAnterior.equals(mensagemModel.payload.body)) {
					
					try {
						Client cliente = Client.builder().apiKey(propertiesFactory.getGeminiKey()).build();

						GenerateContentResponse response = cliente.models.generateContent(ModelosIA.GEMINI_FLASH_LITE.descricao, PromptBuilder.builder().message(mensagemModel.payload.body).getPrompt(), null);
						
						if (!response.text().isEmpty()) {
							
							try {
								String[] addDespesas = response.text().split("\\|");

								Despesas despesa = new Despesas();
								despesa.setItem(addDespesas[0]);
								despesa.setValor(addDespesas[1]);
								despesa.setCategoria(addDespesas[2]);
								despesa.setUserId(user.getId());
								despesa.setDataRegistro(new Date());
								despesasRepository.save(despesa);
								
							} catch (Exception e) {
								System.out.println("Error ao cadastrar despesa " + e);
							}
						}
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					mensagemAnterior = mensagemModel.payload.body;
				}
			}
			
		} catch (Exception e) {
			System.out.println("Error ao obter mensagem" + e);
		}
		
	}

}
