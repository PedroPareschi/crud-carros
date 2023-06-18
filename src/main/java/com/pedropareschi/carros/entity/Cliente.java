package com.pedropareschi.carros.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(length = 100)
    private String nome;

    @NotNull
    @CPF
    private String cpf;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dataDeNascimento;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;
        Cliente cliente = (Cliente) o;
        return id.equals(cliente.id) && nome.equals(cliente.nome) && cpf.equals(cliente.cpf) && dataDeNascimento.equals(cliente.dataDeNascimento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cpf, dataDeNascimento);
    }
}
