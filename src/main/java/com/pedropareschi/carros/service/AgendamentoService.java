package com.pedropareschi.carros.service;

import com.pedropareschi.carros.dtos.AgendamentoDTO;
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

    public Agendamento findByCarroAndCliente(Carro carro, Cliente cliente){
        return repository.findByCarroAndCliente(carro, cliente).orElseThrow(() -> new RuntimeException("Agendamento não encontrado"));
    }

    public Agendamento updateAgendamento(AgendamentoDTO agendamentoDTO){
        Carro carro = carroService.getById(agendamentoDTO.getCarroId());
        Cliente cliente = clienteService.getById(agendamentoDTO.getClienteId());
        Agendamento agendamento = findByCarroAndCliente(carro, cliente);
        return repository.save(agendamento);
    }
}
