package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.modelo.Cliente;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.service.ClienteService;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {
	private final ClienteRepository repo;

    @Override
    public List<Cliente> findAll() {
        return repo.findAll();
    }

    @Override
    public Cliente findById(String documento) {
        return repo.findById(documento).orElse(null);
    }

    @Override
    public Cliente save(Cliente cliente) {
        return repo.save(cliente);
    }

    @Override
    public void delete(String documento) {
        repo.deleteById(documento);
    }
}
