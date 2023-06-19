package com.pedropareschi.carros.repository;

import com.pedropareschi.carros.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
