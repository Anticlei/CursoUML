package com.geous.cursouml.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.geous.cursouml.domain.PK.ItemPedidoPK;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
@Setter
public class ItemPedido implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    @JsonIgnore
    private ItemPedidoPK id =  new ItemPedidoPK();

    private Double desconto;
    private Integer quantidade;
    private Double preco;

    public ItemPedido() {
    }

    public ItemPedido(Pedido pedido, Produto produto, Double desconto, Integer quantidade, Double preco) {
        id.setPedido(pedido);
        id.setProduto(produto);
        this.desconto = desconto;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    @JsonIgnore
    public Pedido getPedido() {
        return id.getPedido();
    }

    public Produto getProduto() {
        return id.getProduto();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ItemPedido that = (ItemPedido) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
