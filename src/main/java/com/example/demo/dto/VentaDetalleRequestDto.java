package com.example.demo.dto;

import lombok.Data;

@Data
public class VentaDetalleRequestDto {
	private Integer productoId;
	private Integer cantidad;
	private Double precio;
}
