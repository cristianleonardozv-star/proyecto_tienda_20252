package com.example.demo.controller;
import com.example.demo.modelo.Venta;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.repository.VentaRepository;

public class VentaController {
	private final VentaRepository ventaRepository;

    public VentaController(VentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
    }

    @GetMapping
    public List<Venta> listar() {
        return ventaRepository.findAll();
    }

    @PostMapping
    public Venta guardar(@RequestBody Venta venta) {
        return ventaRepository.save(venta);
    }
}
