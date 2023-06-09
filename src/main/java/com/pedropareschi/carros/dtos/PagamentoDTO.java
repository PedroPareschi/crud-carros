package com.pedropareschi.carros.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PagamentoDTO {
    @NotNull
    private Long clienteId;
    @NotNull
    private Long carroId;
    @NotNull
    private Integer formaDePagamento;
}
