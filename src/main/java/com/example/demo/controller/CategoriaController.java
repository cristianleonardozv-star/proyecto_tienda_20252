package com.example.demo.controller;
import org.springframework.web.bind.annotation.*;

import com.example.demo.modelo.Categoria;
import com.example.demo.repository.CategoriaRepository;

import java.util.List;

public class CategoriaController {

    private final CategoriaRepository categoriaRepository;

    public CategoriaController(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @GetMapping
    public List<Categoria> listar() {
        return categoriaRepository.findAll();
    }

    @PostMapping
    public Categoria guardar(@RequestBody Categoria categoria) {
        return categoriaRepository.save(categoria);
    }
}