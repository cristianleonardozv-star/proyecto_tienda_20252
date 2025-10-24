package com.example.demo.controller;
import org.springframework.web.bind.annotation.*;

import com.example.demo.modelo.Producto;
import com.example.demo.repository.ProductoRepository;

import java.util.List;
public class ProductoController {

    private final ProductoRepository productoRepository;

    public ProductoController(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @GetMapping
    public List<Producto> listar() {
        return productoRepository.findAll();
    }

    @PostMapping
    public Producto guardar(@RequestBody Producto producto) {
        return productoRepository.save(producto);
    }
}
