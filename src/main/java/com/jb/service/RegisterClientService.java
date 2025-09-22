package com.jb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jb.model.Usuario;
import com.jb.repository.UserRepository;

@Component
public class RegisterClientService {
	
	@Autowired
	UserRepository userRepository;
	
	public int registerNewClient(String nome, String contato, String tipoConta){
		
		if (validate(nome,contato,tipoConta)) {
			
			Usuario user = new Usuario();
			user.setNome(nome);
			user.setContato(contato.concat("@c.us"));
			user.setTipoConta(tipoConta);
			
			userRepository.save(user);
			return 200;
		}else {
			return 400;
		}
	}
	
	
	public boolean validate(String nome, String contato, String tipoConta) {
		
		if(nome.isBlank())
			return false;
		
		if(contato.isBlank())
			return false;
		
		if(tipoConta.isBlank())
			return false;
			
		 Usuario user = userRepository.findByContato(contato.concat("@c.us"));
		 
		 if (user != null) {
			 return false;
		 }else {
			 return true;
		 }
		 
	}
}
