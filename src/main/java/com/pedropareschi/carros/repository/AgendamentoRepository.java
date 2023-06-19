package com.pedropareschi.carros.repository;

import com.pedropareschi.carros.entity.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
}
