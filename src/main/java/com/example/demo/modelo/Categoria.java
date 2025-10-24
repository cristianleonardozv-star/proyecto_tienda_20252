package com.example.demo.modelo;
import lombok.*;

import java.util.List;

import jakarta.persistence.*;
@Entity
@Data
public class Categoria {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;

	    private String descripcion;

	    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, orphanRemoval = true)
	    private List<Producto> productos;
}
