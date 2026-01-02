package com.geous.cursouml.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.geous.cursouml.domain.enums.EstadoPagamento;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public abstract class Pagamento implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;
    private Integer estado;

    @OneToOne
    @JoinColumn(name = "pedido_id")
    @MapsId
    @JsonBackReference
    private Pedido pedido;

    public Pagamento() {
    }

    public Pagamento(Integer id, EstadoPagamento estado, Pedido pedido) {
        this.id = id;
        this.estado = estado.getCodigo();
        this.pedido = pedido;
    }

    public EstadoPagamento getEstado() {
        return EstadoPagamento.toEnum(estado);
    }

    public void setEstado(EstadoPagamento estado) {
        this.estado = estado.getCodigo();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pagamento pagamento = (Pagamento) o;
        return Objects.equals(id, pagamento.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
