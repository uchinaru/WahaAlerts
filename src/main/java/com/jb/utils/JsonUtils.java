package com.jb.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jb.model.JsonWahaModel;

public class JsonUtils {
	
	public static JsonWahaModel transformJsonInObjectWaha(String message) {
		try {
			ObjectMapper bjectMapper = new ObjectMapper();
			return bjectMapper.readValue(message, JsonWahaModel.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		} 
	}

}
