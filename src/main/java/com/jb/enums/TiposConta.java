package com.jb.enums;

public enum TiposConta {
	
	VIP("1"),
	GRATUITO("0");
	
	public String descricao;
	
	TiposConta(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

	

}
