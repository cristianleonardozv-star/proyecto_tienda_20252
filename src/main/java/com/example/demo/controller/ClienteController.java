package com.example.demo.controller;
import com.example.demo.modelo.Cliente;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.repository.ClienteRepository;

public class ClienteController {
	 private final ClienteRepository clienteRepository;

	    public ClienteController(ClienteRepository clienteRepository) {
	        this.clienteRepository = clienteRepository;
	    }

	    @GetMapping
	    public List<Cliente> listar() {
	        return clienteRepository.findAll();
	    }

	    @PostMapping
	    public Cliente guardar(@RequestBody Cliente cliente) {
	        return clienteRepository.save(cliente);
	    }
}
