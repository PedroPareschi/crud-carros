package com.pedropareschi.carros.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
public class AgendamentoDTO {
    @NotNull
    private Long clienteId;
    @NotNull
    private Long carroId;
    @NotNull
    private Date dataInicial;
    @NotNull
    private Date dataFinal;
}
