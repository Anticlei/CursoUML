package com.geous.cursouml.resources;

import com.geous.cursouml.domain.Categoria;
import com.geous.cursouml.domain.Cliente;
import com.geous.cursouml.repository.ClienteRepository;
import com.geous.cursouml.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Cliente> findById(@PathVariable Integer id) {
        Cliente resp = clienteService.buscarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(resp);
    }

}
