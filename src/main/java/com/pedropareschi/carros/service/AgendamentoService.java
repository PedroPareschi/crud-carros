package com.pedropareschi.carros.service;

import com.pedropareschi.carros.entity.Agendamento;
import com.pedropareschi.carros.entity.Carro;
import com.pedropareschi.carros.entity.Cliente;
import com.pedropareschi.carros.repository.AgendamentoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@AllArgsConstructor
public class AgendamentoService {
    private AgendamentoRepository repository;
    private ClienteService clienteService;
    private CarroService carroService;

    public Agendamento fazerAgendamento(Long clienteId, Long carroId, Date dataInicial, Date dataFinal){
        Carro carro = carroService.getById(carroId);
        Cliente cliente = clienteService.getById(clienteId);
        Agendamento agendamento = new Agendamento(cliente, carro, dataInicial, dataFinal);
        return repository.save(agendamento);
    }
}
