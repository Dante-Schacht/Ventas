package com.Ventas.assembler;

import com.Ventas.controllers.VentaController;
import com.Ventas.dto.VentaDTO;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class VentaModelAssembler implements RepresentationModelAssembler<VentaDTO, VentaDTO> {

    @Override
    public VentaDTO toModel(VentaDTO venta) {
        venta.add(linkTo(methodOn(VentaController.class).obtenerPorId(venta.getId())).withSelfRel());
        venta.add(linkTo(methodOn(VentaController.class).listarTodas()).withRel("todas-las-ventas"));
        venta.add(linkTo(methodOn(VentaController.class).actualizar(venta.getId(), venta)).withRel("actualizar"));
        venta.add(linkTo(methodOn(VentaController.class).eliminar(venta.getId())).withRel("eliminar"));
        return venta;
    }
}