package com.geous.cursouml.domain.enums;

import java.util.Objects;

public enum EstadoPagamento {
    PENDENTE(1, "Pendente"),
    QUITADO(2, "Quitado"),
    CANCELADO(2, "Cancelado");

    private final Integer codigo;
    private final String descricao;
    private EstadoPagamento(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }
    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static EstadoPagamento toEnum(Integer codigo) {
        if  (codigo == null) {
            return null;
        }
        for (EstadoPagamento estadoPagamento : EstadoPagamento.values()) {
            if (Objects.equals(estadoPagamento.getCodigo(), codigo)) {
                return estadoPagamento;
            }
        }

        throw new IllegalArgumentException("Id "+codigo+" inválido para EstadoPagamento");
    }

}
