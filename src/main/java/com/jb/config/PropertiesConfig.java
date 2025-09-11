package com.jb.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertiesConfig {
	
	@Value("${gemini.key}")
	private String geminiKey;

	public String getGeminiKey() {
		return geminiKey;
	}
	
}
