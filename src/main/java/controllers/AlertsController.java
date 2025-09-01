package controllers;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import builders.JsonStructureBuilder;
import enums.HTTPMethods;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api")
public class AlertsController {
	
	public static HttpPost post;
	
	@RequestMapping(path = "/message", method = {RequestMethod.POST,RequestMethod.PUT})
	public String reciveMessages(@RequestBody String mensagem) {
		
		System.out.println(mensagem);
		return "Recebida";
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
