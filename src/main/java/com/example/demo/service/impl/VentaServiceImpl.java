package com.example.demo.service.impl;

import com.example.demo.dto.VentaDetalleRequestDto;
import com.example.demo.dto.VentaRequestDto;
import com.example.demo.modelo.Cliente;
import com.example.demo.modelo.Producto;
import com.example.demo.modelo.ProductoVenta;
import com.example.demo.modelo.ProductoVentaId;
import com.example.demo.modelo.Venta;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.repository.ProductoRepository;
import com.example.demo.repository.VentaRepository;
import com.example.demo.service.VentaService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VentaServiceImpl implements VentaService {

    private final ClienteRepository clienteRepository;
    private final VentaRepository ventaRepository;
    private final ProductoRepository productoRepository;

    @Override
    @Transactional
    public String registrarVenta(VentaRequestDto ventaDto) {

        // 1️⃣ Validar cliente
        String documento = ventaDto.getClienteDocumento();
        Cliente cliente = clienteRepository.findById(documento)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado: " + documento));

        // 2️⃣ Crear venta base
        Venta venta = new Venta();
        venta.setCliente(cliente);
        venta.setFecha(LocalDate.now());
        venta.setProductos(new ArrayList<>());

        Venta ventaCreada = ventaRepository.save(venta);

        // 3️⃣ Recorrer productos del detalle
        double totalVenta = 0D;
        List<VentaDetalleRequestDto> detalles = ventaDto.getDetalle();

        for (VentaDetalleRequestDto detalle : detalles) {
            Integer productoId = detalle.getProductoId();

            Producto producto = productoRepository.findById(productoId)
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado: " + productoId));

            // Validar stock
            if (producto.getCantidad() < detalle.getCantidad()) {
                throw new RuntimeException("Stock insuficiente del producto: " + producto.getNombre());
            }

            // Crear ProductoVenta
            ProductoVenta productoVenta = new ProductoVenta();
            productoVenta.setVenta(ventaCreada);
            productoVenta.setProducto(producto);
            productoVenta.setCantidad(detalle.getCantidad());
            productoVenta.setPrecio(detalle.getPrecio());

            // Clave compuesta con Integer
            ProductoVentaId id = new ProductoVentaId();
            id.setVentaId(ventaCreada.getId());
            id.setProductoId(productoId);
            productoVenta.setId(id);

            // Agregar a la lista
            ventaCreada.getProductos().add(productoVenta);

            // Calcular subtotal
            totalVenta += detalle.getCantidad() * detalle.getPrecio();

            // Actualizar stock
            producto.setCantidad(producto.getCantidad() - detalle.getCantidad());
            productoRepository.save(producto);
        }

        // 4️⃣ Actualizar total de venta
        ventaCreada.setTotal(totalVenta);
        ventaRepository.save(ventaCreada);

        return "Venta registrada correctamente con total: " + totalVenta;
    }
}
