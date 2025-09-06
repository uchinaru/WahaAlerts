package com.jb.enums;

public enum ModelosIA {
	
	GEMINI_FLASH_LITE("gemini-2.5-flash-lite");
	
	public String descricao;
	
	ModelosIA(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
