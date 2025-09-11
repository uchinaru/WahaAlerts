package com.jb.controllers;

import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jb.config.PropertiesConfig;
import com.jb.repository.DespesasRepository;
import com.jb.repository.UserRepository;
import com.jb.services.ProcessMessageService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api")
public class MessageController {
	
	@Autowired
	ProcessMessageService processMessageService;
	
	public static HttpPost post;
	public String mensagemAnterior = "";
	
	@PostMapping("/message")
	public void reciveMessages(@RequestBody String mensagem) {
		processMessageService.processaMensagem(mensagem);
	}
}
