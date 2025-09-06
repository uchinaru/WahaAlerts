package com.jb.builders;

public class PromptBuilder {
	
	String instrucoes = """
			Você receberá um texto descrevendo uma compra ou gasto.
			Sua tarefa é identificar e extrair exatamente três informações, nesta ordem:
			
			O nome do item adquirido (resuma de forma clara e genérica, ex: "Compra do mês", "Tênis esportivo", "Cadeira de escritório").
			
			O valor gasto (somente número muito bem formatado considerando o seu tamanho, analise de forma correta, ex: 500,00 ou 10,000.00 ou 1.000.000,00).
			
			A categoria do item (exemplos: Alimentação, Transporte, Saúde, Educação, Lazer, Moradia, Tecnologia, Vestuário, Serviços, Outros).
			
			Retorne os três elementos separados por pipe (|) e um espaço antes e depois de cada pipe.
			Não inclua etiquetas, explicações ou qualquer outro conteúdo.
			Não inclua mensagens repetidas em um curto intervalo de tempo, por exemplo menos de 15 minutos.
			
			Exemplo:
			
			Entrada: "Gastei 500 reais com mercado essa semana"
			Saída: Compra do mês|500,00|Alimentação
			
			Se qualquer uma das três informações estiver ausente ou impossível de identificar com clareza, retorne vazio.
			""";
	
	String mesagem ="";
	
	public static PromptBuilder builder() {
		return new PromptBuilder();
	}
	
	public PromptBuilder message(String message) {
		this.mesagem = message;
		return this;
	}
	
	public String getPrompt() {
		return instrucoes + "\n\nEntrada: \"" + mesagem + "\"\nSaída:";
	}

}
