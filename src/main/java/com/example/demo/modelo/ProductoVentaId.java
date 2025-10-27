package com.example.demo.modelo;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoVentaId implements Serializable {
    private Integer ventaId;      // 👈 estos nombres DEBEN coincidir
    private Integer productoId;   // 👈 con los de @MapsId en ProductoVenta
}
