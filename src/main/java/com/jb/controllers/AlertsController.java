package com.jb.controllers;

import java.io.IOException;
import java.util.Date;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import com.jb.builders.JsonStructureBuilder;
import com.jb.builders.PromptBuilder;
import com.jb.enums.HTTPMethods;
import com.jb.enums.ModelosIA;
import com.jb.enums.TiposConta;
import com.jb.factory.PropertiesFactory;
import com.jb.models.Despesas;
import com.jb.models.JsonWahaModel;
import com.jb.models.Usuario;
import com.jb.repository.DespesasRepository;
import com.jb.repository.UserRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api")
public class AlertsController {
	
	@Autowired
	public DespesasRepository despesasRepository;
	
	@Autowired
	public UserRepository userRepository;
	
	@Autowired
	public PropertiesFactory propertiesFactory;
	
	public static HttpPost post;
	public String mensagemAnterior = "";
	
	@PostMapping("/message")
	public void reciveMessages(@RequestBody String mensagem) {
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
				sendSimpleMessage(mensagemModel.payload.from, "Cadastrado com sucesso, já pode fazer seus registros", mensagemModel.session);
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
	
	public static void getSessions() throws IOException, ParseException {
		
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet get = new HttpGet(HTTPMethods.GET_SESSIONS.descricao);
		
		CloseableHttpResponse response = client.execute(get);
		
		HttpEntity entity = response.getEntity();
		String resultContent = EntityUtils.toString(entity);
		
		System.out.println(resultContent);
	}
	
	public static void sendSimpleMessage(String numero,String mensagem,String session) throws IOException {
		
		CloseableHttpClient client = HttpClients.createDefault();
		
		post = new HttpPost(HTTPMethods.SEND_TEXT.descricao);
        post.setHeader("Content-Type", "application/json");
		
        String mensagemTratada = JsonStructureBuilder.builder().number(numero).mensagem(mensagem).session(session).getSimpleMensagem();
        post.setEntity(new StringEntity(mensagemTratada));

        var response = client.execute(post);
        System.out.println(response.toString());
	}
	
	public static void sendAlertWhitButtons(String numero,String title,String mensagem,String session) throws IOException {
		
		CloseableHttpClient client = HttpClients.createDefault();
		
		HttpPost post = new HttpPost(HTTPMethods.SEND_BUTTONS.descricao);
        post.setHeader("Content-Type", "application/json");
		
        String mensagemTratada = JsonStructureBuilder.builder().number(numero).title(title).mensagem(mensagem).session(session).getMensagemWhitButtons();
        post.setEntity(new StringEntity(mensagemTratada));

        var response = client.execute(post);
        System.out.println(response.toString());
	}
	
	public static void sendMensagemWhitIMG(String session,String numero,String url,String fileName,String caption) throws IOException {
		
		CloseableHttpClient client = HttpClients.createDefault();
		
		HttpPost post = new HttpPost(HTTPMethods.SEND_IMG.descricao);
        post.setHeader("Content-Type", "application/json");
		
        String mensagemTratada = JsonStructureBuilder.builder().session(session).number(numero).url(url).fileName(fileName).caption(caption).getMensagemWhitIMG();
        post.setEntity(new StringEntity(mensagemTratada));

        var response = client.execute(post);
        System.out.println(response.toString());
	}
	
	public static void getChannels(String session) throws IOException, ParseException{
		
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet get = new HttpGet(HTTPMethods.GET_GROUPS.descricao.replace("SESSION", session));
		
		CloseableHttpResponse response = client.execute(get);
		
		HttpEntity entity = response.getEntity();
		String resultContent = EntityUtils.toString(entity);
		
		System.out.println(resultContent);
	}
	
}
