package com.geous.cursouml.domain.enums;

import java.util.Objects;

public enum TipoCliente {
    PESSOAFISICA(1, "Pessoa Física"),
    PESSOAJURIDICA(2, "Pessoa Jurídica");
    private final Integer codigo;
    private final String descricao;
    private TipoCliente(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }
    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoCliente toEnum(Integer codigo) {
        if  (codigo == null) {
            return null;
        }
        for (TipoCliente tipoCliente : TipoCliente.values()) {
            if (Objects.equals(tipoCliente.getCodigo(), codigo)) {
                return tipoCliente;
            }
        }

        throw new IllegalArgumentException("Id "+codigo+" inválido para TipoCliente");
    }
}
