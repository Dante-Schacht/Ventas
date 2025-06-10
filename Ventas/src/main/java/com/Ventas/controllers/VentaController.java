package com.Ventas.controllers;

import com.Ventas.dto.VentaDTO;
import com.Ventas.services.VentaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ventas")
@RequiredArgsConstructor
public class VentaController {

    private final VentaService ventaService;

    @GetMapping
    public List<VentaDTO> listarTodas() {
        return ventaService.obtenerTodas();
    }

    @GetMapping("/{id}")
    public VentaDTO obtenerPorId(@PathVariable Long id) {
        return ventaService.obtenerPorId(id);
    }

    @PostMapping
    public ResponseEntity<VentaDTO> crear(@RequestBody VentaDTO dto) {
        return new ResponseEntity<>(ventaService.crear(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public VentaDTO actualizar(@PathVariable Long id, @RequestBody VentaDTO dto) {
        return ventaService.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        ventaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
