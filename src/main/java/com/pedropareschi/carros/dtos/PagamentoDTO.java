package com.pedropareschi.carros.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
