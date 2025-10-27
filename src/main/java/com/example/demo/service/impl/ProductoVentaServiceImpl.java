package com.example.demo.service.impl;

import com.example.demo.modelo.ProductoVenta;
import com.example.demo.modelo.ProductoVentaId;
import com.example.demo.repository.ProductoVentaRepository;
import com.example.demo.service.ProductoVentaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoVentaServiceImpl implements ProductoVentaService {

    private final ProductoVentaRepository productoVentaRepository;

    @Override
    public List<ProductoVenta> findAll() {
        return productoVentaRepository.findAll();
    }

    @Override
    public ProductoVenta findById(ProductoVentaId id) {
        return productoVentaRepository.findById(id).orElse(null);
    }

    @Override
    public ProductoVenta save(ProductoVenta productoVenta) {
        return productoVentaRepository.save(productoVenta);
    }

    @Override
    public void delete(ProductoVentaId id) {
        productoVentaRepository.deleteById(id);
    }
}
