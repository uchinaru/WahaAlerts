package com.jb.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jb.model.DTOJsonWaha;

public class JsonUtils {
	
	public static DTOJsonWaha transformJsonInObjectWaha(String message) {
		try {
			ObjectMapper bjectMapper = new ObjectMapper();
			return bjectMapper.readValue(message, DTOJsonWaha.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		} 
	}

}
