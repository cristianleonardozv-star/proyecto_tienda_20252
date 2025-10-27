package com.example.demo.controller;

import com.example.demo.dto.VentaRequestDto;
import com.example.demo.service.VentaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ventas")
@CrossOrigin(origins = "*")
public class VentaController {

    private final VentaService ventaService;

    public VentaController(VentaService ventaService) {
        this.ventaService = ventaService;
    }

    @PostMapping("/registrar")
    public ResponseEntity<String> registrarVenta(@RequestBody VentaRequestDto venta) {
        String mensaje = ventaService.registrarVenta(venta);
        return ResponseEntity.ok(mensaje);
    }
}
