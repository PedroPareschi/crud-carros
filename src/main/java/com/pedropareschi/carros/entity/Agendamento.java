package com.pedropareschi.carros.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
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
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dataInicio;

    @Column
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dataFinal;


}