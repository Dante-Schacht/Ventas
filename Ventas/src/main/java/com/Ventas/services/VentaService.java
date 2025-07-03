package com.Ventas.services;

import com.Ventas.dto.VentaDTO;
import com.Ventas.models.Venta;
import com.Ventas.repository.VentaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VentaService {

    private final VentaRepository ventaRepository;

    public List<VentaDTO> obtenerTodas() {
        return ventaRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public VentaDTO obtenerPorId(Long id) {
        return ventaRepository.findById(id)
                .map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada"));
    }

    public VentaDTO crear(VentaDTO dto) {
        Venta venta = toEntity(dto);
        return toDTO(ventaRepository.save(venta));
    }

    public VentaDTO actualizar(Long id, VentaDTO dto) {
        Venta venta = ventaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada"));

        venta.setFecha(dto.getFecha());
        venta.setMontoTotal(dto.getMontoTotal());
        venta.setIdVendedor(dto.getIdVendedor());

        return toDTO(ventaRepository.save(venta));
    }

    public void eliminar(Long id) {
        ventaRepository.deleteById(id);
    }

    private VentaDTO toDTO(Venta venta) {
        return new VentaDTO(venta.getId(), venta.getFecha(), venta.getProducto(), venta.getMontoTotal(), venta.getIdVendedor());
    }

    private Venta toEntity(VentaDTO dto) {
        return new Venta(dto.getId(), dto.getProducto(), dto.getFecha(), dto.getMontoTotal(), dto.getIdVendedor());
    }
}
