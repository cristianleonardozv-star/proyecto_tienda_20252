package com.example.demo.repository;

import com.example.demo.modelo.ProductoVenta;
import com.example.demo.modelo.ProductoVentaId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoVentaRepository extends JpaRepository<ProductoVenta, ProductoVentaId> {
}
