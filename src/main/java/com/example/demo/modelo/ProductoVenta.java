package com.example.demo.modelo;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Data
public class ProductoVenta {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "venta_id")
	    private Venta venta;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "producto_id")
	    private Producto producto;

	    private Integer cantidad;
	    private Double precio;
}
