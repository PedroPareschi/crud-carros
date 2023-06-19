package com.pedropareschi.carros.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String modelo;
    @NotBlank
    @Pattern(regexp = "[A-Z]{3}[0-9]{1}[A-Z0-9]{1}[0-9]{2}")
    private String placa;
    private Double valor;
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date data;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Carro carro = (Carro) o;
        return id != null && Objects.equals(id, carro.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
