package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modelo.Venta;

public interface VentaRepository extends JpaRepository<Venta, Long> { }
