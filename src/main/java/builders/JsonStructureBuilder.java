package builders;

public class JsonStructureBuilder {
	
	private String MENSAGEM_TEXT = "{\"chatId\":\"NUMBER\",\r\n"
    		+ "\"reply_to\": null,\r\n"
    		+ "\"text\": \"MENSAGEM\",\r\n"
    		+ "\"linkPreview\": true,\r\n"
    		+ "\"linkPreviewHighQuality\": false,\r\n"
    		+ "\"session\":\"SESSION\"\r\n}";
	
	private String MENSAGEM_TEXT_WHIT_BUTTONS = "{\r\n"
			+ "  \"chatId\": \"NUMBER\",\r\n"
			+ "  \"header\": \"TITLE\",\r\n"
			+ "  \"headerImage\": {\r\n"
			+ "    \"mimetype\": \"image/jpeg\",\r\n"
			+ "    \"filename\": \"filename.jpg\",\r\n"
			+ "    \"url\": \"https://github.com/devlikeapro/waha/raw/core/examples/waha.jpg\"\r\n"
			+ "  },\r\n"
			+ "  \"body\": \"MENSAGEM\",\r\n"
			+ "  \"footer\": \"If you have any questions, please send it in the chat\",\r\n"
			+ "  \"buttons\": [\r\n"
			+ "    {\r\n"
			+ "      \"type\": \"reply\",\r\n"
			+ "      \"text\": \"I am good!\"\r\n"
			+ "    },\r\n"
			+ "    {\r\n"
			+ "      \"type\": \"call\",\r\n"
			+ "      \"text\": \"Call us\",\r\n"
			+ "      \"phoneNumber\": \"+1234567890\"\r\n"
			+ "    },\r\n"
			+ "    {\r\n"
			+ "      \"type\": \"copy\",\r\n"
			+ "      \"text\": \"Copy code\",\r\n"
			+ "      \"copyCode\": \"4321\"\r\n"
			+ "    },\r\n"
			+ "    {\r\n"
			+ "      \"type\": \"url\",\r\n"
			+ "      \"text\": \"How did you do that?\",\r\n"
			+ "      \"url\": \"https://waha.devlike.pro\"\r\n"
			+ "    }\r\n"
			+ "  ],\r\n"
			+ "  \"session\": \"SESSION\"\r\n"
			+ "}";
	
	private String SEND_IMG = "{\r\n"
			+ "  \"session\": \"SESSION\",\r\n"
			+ "  \"chatId\": \"NUMBER\",\r\n"
			+ "  \"file\": {\r\n"
			+ "    \"mimetype\": \"image/jpeg\",\r\n"
			+ "    \"url\": \"URL\",\r\n"
			+ "    \"filename\": \"FILENAME\"\r\n"
			+ "  },\r\n"
			+ "  \"caption\": \"CAPTION\"\r\n"
			+ "}";
	
	private String mensagem ="";
	private String session = "";
	private String number = "";
	private String title = "";
	private String url = "";
	private String filename = "";
	private String caption = "";
	
	public static JsonStructureBuilder builder(){
		return new JsonStructureBuilder();
	}
	
	public JsonStructureBuilder mensagem(String mensagem) {
		this.mensagem = mensagem;
		return this;
	}
	
	public JsonStructureBuilder session(String session) {
		this.session = session;
		return this;
	}
	
	public JsonStructureBuilder number(String number) {
		this.number = number;
		return this;
	}
	
	public JsonStructureBuilder title(String title) {
		this.title = title;
		return this;
	}
	
	public JsonStructureBuilder url(String url) {
		this.url = url;
		return this;
	}
	
	public JsonStructureBuilder fileName(String filename) {
		this.filename = filename;
		return this;
	}
	
	public JsonStructureBuilder caption(String caption) {
		this.caption = caption;
		return this;
	}
	
	public String getSimpleMensagem() {
		return MENSAGEM_TEXT.replace("NUMBER", this.number).replace("MENSAGEM", this.mensagem).replace("SESSION", this.session);
	}
	
	public String getMensagemWhitButtons() {
		return MENSAGEM_TEXT_WHIT_BUTTONS.replace("NUMBER", this.number).replace("TITLE", this.title).replace("MENSAGEM", this.mensagem).replace("SESSION", this.session);
	}
	
	public String getMensagemWhitIMG() {
		return SEND_IMG.replace("SESSION", this.session).replace("NUMBER", this.number).replace("URL", this.url).replace("FILENAME", this.filename).replace("CAPTION", this.caption);
	}
}
