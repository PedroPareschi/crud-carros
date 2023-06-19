package com.pedropareschi.carros.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class AgendamentoPK implements Serializable {
    @Column(name = "cliente_id")
    private Long clienteId;
    @Column(name = "carro_id")
    private Long carroId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AgendamentoPK that = (AgendamentoPK) o;
        return Objects.equals(clienteId, that.clienteId) &&
                Objects.equals(carroId, that.carroId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clienteId, carroId);
    }
}