package com.example.demo.controller;


import org.springframework.web.bind.annotation.*;

import com.example.demo.modelo.Cliente;
import com.example.demo.repository.ClienteRepository;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    @GetMapping("/{documento}")
    public Cliente obtener(@PathVariable String documento) {
        return clienteRepository.findById(documento).orElse(null);
    }

    @PostMapping
    public Cliente crear(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @PutMapping("/{documento}")
    public Cliente actualizar(@PathVariable String documento, @RequestBody Cliente cliente) {
        cliente.setDocumento(documento);
        return clienteRepository.save(cliente);
    }

    @DeleteMapping("/{documento}")
    public void eliminar(@PathVariable String documento) {
        clienteRepository.deleteById(documento);
    }
}
