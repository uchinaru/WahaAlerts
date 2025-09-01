package enums;

public enum FormasDePagamentos {
	
	DEBITO("Cartão de Debito"),
	CREDITO("Cartão de Crédito"),
	DINHEIRO("Cédulas"),
	VR("Vale Refeição"),
	VA("Vale Alimentação");
	
	public String descricao;
	
	FormasDePagamentos(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
