package enums;

public enum HTTPMethods {
	
	SEND_TEXT("http://localhost:3000/api/sendText"),
	GET_SESSIONS("http://localhost:3000/api/sessions"),
	SEND_BUTTONS("http://localhost:3000/api/sendButtons"),
	SEND_IMG("http://localhost:3000/api/sendImage"),
	GET_GROUPS("http://localhost:3000/api/SESSION/groups");

	public String descricao;
	
	HTTPMethods(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
}
