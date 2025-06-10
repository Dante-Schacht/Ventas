package com.Ventas.dto;

import lombok.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VentaDTO {
    private Long id;
    private LocalDate fecha;
    private Double montoTotal;
    private Long idVendedor;
}


