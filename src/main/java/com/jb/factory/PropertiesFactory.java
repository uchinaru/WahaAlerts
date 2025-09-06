package com.jb.factory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertiesFactory {
	
	@Value("${gemini.key}")
	private String geminiKey;

	public String getGeminiKey() {
		return geminiKey;
	}
	
}
