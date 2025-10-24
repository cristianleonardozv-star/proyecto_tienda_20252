package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modelo.ProductoVenta;

public interface ProductoVentaRepository extends JpaRepository<ProductoVenta, Long> { }