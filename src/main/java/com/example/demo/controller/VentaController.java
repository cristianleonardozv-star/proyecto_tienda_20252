package com.example.demo.controller;


import org.springframework.web.bind.annotation.*;

import com.example.demo.modelo.Venta;
import com.example.demo.repository.VentaRepository;

import java.util.List;

@RestController
@RequestMapping("/ventas")
public class VentaController {

    private final VentaRepository ventaRepository;

    public VentaController(VentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
    }

    @GetMapping
    public List<Venta> listar() {
        return ventaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Venta obtener(@PathVariable Integer id) {
        return ventaRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Venta crear(@RequestBody Venta venta) {
        return ventaRepository.save(venta);
    }

    @PutMapping("/{id}")
    public Venta actualizar(@PathVariable Integer id, @RequestBody Venta venta) {
        venta.setId(id);
        return ventaRepository.save(venta);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        ventaRepository.deleteById(id);
    }
}
