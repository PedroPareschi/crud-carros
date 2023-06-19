package com.pedropareschi.carros.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
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
    private List<Pagamento> pagamentos;

    @Column
    @NotBlank
    @Temporal(TemporalType.DATE)
    private Date dataInicial;

    @Column
    @NotBlank
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