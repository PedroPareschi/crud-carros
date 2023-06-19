package com.pedropareschi.carros.controller;

import com.pedropareschi.carros.dtos.PagamentoDTO;
import com.pedropareschi.carros.entity.Pagamento;
import com.pedropareschi.carros.service.PagamentoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/pagamentos")
@AllArgsConstructor
public class PagamentoController {

    private PagamentoService service;

    @PostMapping
    private ResponseEntity<Pagamento> fazerPagamento(@Valid @RequestBody PagamentoDTO pagamentoDTO) {
        return ResponseEntity.ok().body(service.fazerPagamento(pagamentoDTO));
    }
}
