package com.jb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jb.service.ProcessMessageService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api")
public class MessageController {
	
	@Autowired
	ProcessMessageService processMessageService;
	
	@PostMapping("/message")
	public void reciveMessages(@RequestBody String mensagem) {
		processMessageService.processaMensagem(mensagem);
	}
}
