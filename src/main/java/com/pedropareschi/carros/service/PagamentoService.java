package com.pedropareschi.carros.service;

import com.pedropareschi.carros.dtos.PagamentoDTO;
import com.pedropareschi.carros.entity.Agendamento;
import com.pedropareschi.carros.entity.Carro;
import com.pedropareschi.carros.entity.Cliente;
import com.pedropareschi.carros.entity.Pagamento;
import com.pedropareschi.carros.entity.enums.FormaDePagamento;
import com.pedropareschi.carros.repository.PagamentoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PagamentoService {
    private PagamentoRepository repository;
    private AgendamentoService agendamentoService;
    private CarroService carroService;
    private ClienteService clienteService;

    public Pagamento fazerPagamento(PagamentoDTO pagamentoDTO){
        Carro carro = carroService.getById(pagamentoDTO.getCarroId());
        Cliente cliente = clienteService.getById(pagamentoDTO.getClienteId());
        Agendamento agendamento = agendamentoService.findByCarroAndCliente(carro, cliente);
        FormaDePagamento formaDePagamento = FormaDePagamento.toEnum(pagamentoDTO.getFormaDePagamento());
        Pagamento pagamento = new Pagamento(null, agendamento, cliente, formaDePagamento);
        return repository.save(pagamento);
    }
}
