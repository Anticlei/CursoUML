package com.geous.cursouml.resources;

import com.geous.cursouml.domain.Pedido;
import com.geous.cursouml.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {
    @Autowired
    private PedidoService pedidoService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Pedido> findById(@PathVariable Integer id) {
        Pedido resp = pedidoService.buscarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(resp);
    }

}
