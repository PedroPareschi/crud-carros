package com.pedropareschi.carros.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public enum FormaDePagamento {
    CARTAO_DE_CREDITO(1, "Cartão de crédito"),
    A_VISTA(2, "Á Vista");

    private final Integer codigo;
    private final String nome;

    FormaDePagamento(Integer codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }
}
