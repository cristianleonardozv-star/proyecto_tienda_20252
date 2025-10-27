package com.example.demo.controller;


import org.springframework.web.bind.annotation.*;

import com.example.demo.modelo.Producto;
import com.example.demo.repository.ProductoRepository;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoRepository productoRepository;

    public ProductoController(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @GetMapping
    public List<Producto> listar() {
        return productoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Producto obtener(@PathVariable Integer id) {
        return productoRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Producto crear(@RequestBody Producto producto) {
        return productoRepository.save(producto);
    }

    @PutMapping("/{id}")
    public Producto actualizar(@PathVariable Integer id, @RequestBody Producto producto) {
        producto.setId(id);
        return productoRepository.save(producto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        productoRepository.deleteById(id);
    }
}
