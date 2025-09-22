package com.jb.enums;

public enum TiposConta {
	
	GRATUITO("0"),
	PAGO("1"),
	TESTE_GRATUITO("2");
	
	public String descricao;
	
	TiposConta(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

	

}
