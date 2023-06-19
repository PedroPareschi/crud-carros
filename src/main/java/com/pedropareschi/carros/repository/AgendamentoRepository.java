package com.pedropareschi.carros.repository;

import com.pedropareschi.carros.entity.Agendamento;
import com.pedropareschi.carros.entity.Carro;
import com.pedropareschi.carros.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
    Optional<Agendamento> findByCarroAndCliente(Carro carro, Cliente cliente);
}
