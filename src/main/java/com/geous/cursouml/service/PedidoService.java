package com.geous.cursouml.service;

import com.geous.cursouml.domain.Cliente;
import com.geous.cursouml.domain.Pedido;
import com.geous.cursouml.repository.PedidoRepository;
import com.geous.cursouml.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido buscarPorId(Integer id) {
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        return pedido.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
    }
}
