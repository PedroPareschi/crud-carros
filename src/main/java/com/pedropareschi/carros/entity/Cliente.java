package com.pedropareschi.carros.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Objects;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "cpf"))
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(length = 100)
    private String nome;

    @NotBlank
    @CPF
    private String cpf;

    @Temporal(TemporalType.DATE)
    private Date dataDeNascimento;

    @NotBlank
    private String senha;

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
