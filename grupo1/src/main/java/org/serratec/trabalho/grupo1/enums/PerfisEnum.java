package org.serratec.trabalho.grupo1.enums;

public enum PerfisEnum {
	ADMIN(1,"admin"),
	COMUM(2,"comum");
	
    private final int codigo;
    private final String descricao;

    PerfisEnum(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }
	
	
}
