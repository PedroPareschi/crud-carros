package com.pedropareschi.carros.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Agendamento {

    @EmbeddedId
    @JsonIgnore
    private AgendamentoPK id;

    @ManyToOne
    @MapsId("clienteId")
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @MapsId("carroId")
    @JoinColumn(name = "carro_id")
    private Carro carro;

    @OneToMany(mappedBy = "agendamento", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Pagamento> pagamentos;

    @Column
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dataInicial;

    @Column
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dataFinal;

    public Agendamento(Cliente cliente, Carro carro, Date dataInicial, Date dataFinal) {
        this.id = new AgendamentoPK(cliente.getId(), carro.getId());
        this.cliente = cliente;
        this.carro = carro;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
    }
}