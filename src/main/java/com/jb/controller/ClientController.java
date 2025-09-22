package com.jb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jb.service.RegisterClientService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "api/client")
public class ClientController {
	
	@Autowired
	RegisterClientService registerClientService;
	
	@PostMapping("/new")
	public int registerClient(@RequestParam String nome, String contato, String tipoConta) {
		return registerClientService.registerNewClient(nome, contato, tipoConta);
	}
}
