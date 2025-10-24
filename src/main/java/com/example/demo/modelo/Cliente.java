package com.example.demo.modelo;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;
@Entity
@Data
public class Cliente {
	
	 @Id
	    private String documento; // clave primaria

	    private String nombre;
	    private LocalDate fechaNacimiento;
	    private String email;

	    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
	    private List<Venta> ventas;

}
