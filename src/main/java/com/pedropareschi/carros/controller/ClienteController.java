package com.pedropareschi.carros.controller;

import com.pedropareschi.carros.entity.Cliente;
import com.pedropareschi.carros.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/clientes")
@AllArgsConstructor
public class ClienteController {
    private ClienteService service;

    @PostMapping
    private ResponseEntity<Cliente> cadastrarCliente(@Valid @RequestBody Cliente cliente) {
        return ResponseEntity.ok().body(service.cadastrarCliente(cliente));
    }
}
