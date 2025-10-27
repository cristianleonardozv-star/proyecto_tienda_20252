package com.example.demo.controller;


import org.springframework.web.bind.annotation.*;

import com.example.demo.modelo.Categoria;
import com.example.demo.repository.CategoriaRepository;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaRepository categoriaRepository;

    public CategoriaController(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @GetMapping
    public List<Categoria> listar() {
        return categoriaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Categoria obtener(@PathVariable Integer id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Categoria crear(@RequestBody Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @PutMapping("/{id}")
    public Categoria actualizar(@PathVariable  Integer id , @RequestBody Categoria categoria) {
        categoria.setId(id);
        return categoriaRepository.save(categoria);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        categoriaRepository.deleteById(id);
    }
}
