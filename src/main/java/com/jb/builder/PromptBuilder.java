package com.jb.builder;

public class PromptBuilder {
	
	String promptRegisterExpend = """
			Você receberá entradas de texto que podem ou não descrever uma compra ou gasto.
			
			Sua tarefa é identificar e extrair exatamente três informações, nesta ordem e com este formato:
			
			[Nome genérico do item] | [Valor gasto bem formatado] | [Categoria]
			
			Regras:
			
			- O nome do item deve ser genérico, como: "Compra do mês", "Tênis esportivo", "Cadeira de escritório".
			- O valor deve estar no formato monetário ex: 500,00 ou 10.000,00 ou 1.000.000,00.
			- A categoria deve ser uma das seguintes: Alimentação, Transporte, Saúde, Educação, Lazer, Moradia, Tecnologia, Vestuário, Serviços, Outros.
			- Se qualquer uma das três informações estiver ausente ou ambígua, retorne Null.
			- Não responda a mensagens que não descrevem um gasto, como "Oi", "Olá", "Tenho uma dúvida", etc.
			- Não inclua colchetes, vírgulas entre os campos, explicações ou qualquer outro conteúdo além do especificado.
			- Não repita mensagens em menos de 5 minutos, mesmo se forem iguais.
			
			Formato de resposta (somente quando válido):
			Nome do item | Valor | Categoria
			
			Exemplos:
			
			Entrada: Gastei 500 reais com mercado essa semana  
			Saída: Compra do mês|500,00|Alimentação
			
			Entrada: Comprei um tênis por R$ 350,00  
			Saída: Tênis esportivo|350,00|Vestuário
			
			Entrada: Olá, tudo bem?  
			retorne Null
			
			Entrada: Comprei um presente  
			retorne Null — falta valor e categoria
			
			""";
	
	String mesagem ="";
	
	public static PromptBuilder builder() {
		return new PromptBuilder();
	}
	
	public PromptBuilder message(String message) {
		this.mesagem = message;
		return this;
	}
	
	public String getExpense() {
		return promptRegisterExpend + "\n\nEntrada: \"" + mesagem + "\"\nSaída:";
	}

}
