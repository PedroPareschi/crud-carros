package com.pedropareschi.carros.controller;

import com.pedropareschi.carros.dtos.AgendamentoDTO;
import com.pedropareschi.carros.entity.Agendamento;
import com.pedropareschi.carros.service.AgendamentoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/agendamentos")
@AllArgsConstructor
public class AgendamentoController {
    private AgendamentoService service;

    @PostMapping
    private ResponseEntity<Agendamento> fazerAgendamento(@Valid @RequestBody AgendamentoDTO agendamentoDTO) {
        Agendamento agendamento = service.fazerAgendamento(agendamentoDTO.getClienteId(), agendamentoDTO.getCarroId(), agendamentoDTO.getDataInicial(), agendamentoDTO.getDataFinal());
        return ResponseEntity.ok().body(agendamento);
    }
}
