package com.example.demo.dto;

import java.util.List;

import lombok.Data;
@Data
public class VentaRequestDto {
	private String clienteDocumento;
	private List<VentaDetalleRequestDto> detalle;
}
