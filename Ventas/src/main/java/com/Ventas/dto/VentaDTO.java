package com.Ventas.dto;

import lombok.*;
import java.time.LocalDate;
import org.springframework.hateoas.RepresentationModel;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VentaDTO extends RepresentationModel<VentaDTO>{
    private Long id;
    private LocalDate fecha;
    private String producto;
    private Double montoTotal;
    private Long idVendedor;
}


