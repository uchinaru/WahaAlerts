package com.jb.controllers;

import java.io.IOException;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jb.builders.JsonStructureBuilder;
import com.jb.enums.HTTPMethods;
import com.jb.models.JsonWahaModel;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api")
public class AlertsController {
	
	public static HttpPost post;
	
	@PostMapping("/message")
	public void reciveMessages(@RequestBody String mensagem) {
		try {
			System.out.println(mensagem);

			ObjectMapper obj = new ObjectMapper();
			
			JsonWahaModel mensagemModel = obj.readValue(mensagem, JsonWahaModel.class);
			
			System.out.println(mensagemModel.toString());
		} catch (Exception e) {
			System.out.println("Error ao obter mensagem");
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
	
	public static void sendSimpleAlert(String numero,String mensagem,String session) throws IOException {
		
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
