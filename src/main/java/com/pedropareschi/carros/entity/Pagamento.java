package com.pedropareschi.carros.entity;

import com.pedropareschi.carros.entity.enums.FormaDePagamento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Agendamento agendamento;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @NotNull
    @Enumerated(EnumType.STRING)
    private FormaDePagamento formaDePagamento;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pagamento)) return false;
        Pagamento pagamento = (Pagamento) o;
        return id.equals(pagamento.id) && Objects.equals(agendamento, pagamento.agendamento) && Objects.equals(cliente, pagamento.cliente) && formaDePagamento == pagamento.formaDePagamento;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, agendamento, cliente, formaDePagamento);
    }
}
