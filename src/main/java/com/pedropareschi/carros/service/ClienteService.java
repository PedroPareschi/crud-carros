package com.pedropareschi.carros.service;

import com.pedropareschi.carros.entity.Cliente;
import com.pedropareschi.carros.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClienteService {
    private ClienteRepository repository;

    public Cliente cadastrarCliente(Cliente cliente){
        return repository.save(cliente);
    }

    public Cliente getById(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Erro não encontrado"));
    }
}
