package com.example.demo.modelo;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "producto_venta")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductoVenta {

    @EmbeddedId
    private ProductoVentaId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("ventaId")  // 👈 usa el mismo nombre que en ProductoVentaId
    @JoinColumn(name = "venta_id")
    private Venta venta;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("productoId")  // 👈 igual que en ProductoVentaId
    @JoinColumn(name = "producto_id")
    private Producto producto;

    private Integer cantidad;
    private BigDecimal precio;
}
