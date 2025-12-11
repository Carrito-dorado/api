package com.example.carritodorado.controller;

import lombok.RequiredArgsConstructor;
import com.example.carritodorado.dto.CarritoResponseDTO;
import com.example.carritodorado.dto.DetalleCarritoResponse;
import com.example.carritodorado.model.Carrito;
import com.example.carritodorado.model.DetalleCarrito;

import com.example.carritodorado.service.CarritoService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/carrito")
@RequiredArgsConstructor
public class CarritoController {

    //USA IMPL2
    private final CarritoService carritoService;
    //private final CarritoServiceImpl carritoServiceimpl;

    @PostMapping
    public ResponseEntity<?> crearCarrito(@RequestBody Carrito carrito) {

        var carrtioSaved = carritoService.create(carrito);
        List<DetalleCarritoResponse> detalleCarritoResponses = new ArrayList<>(carrtioSaved.getDetallesCarrito().size());
        for (DetalleCarrito line : carrito.getDetallesCarrito()) {
            DetalleCarritoResponse detalleCarritoResponse = DetalleCarritoResponse.builder()
                    .total(line.getTotal())
                    .id(line.getId())
                    .precio(line.getPrecio())
                    .cantidad(line.getCantidad())
                    .nombreProducto(line.getProducto().getNombre())
                    .build();
            detalleCarritoResponses.add(detalleCarritoResponse);


        }

        CarritoResponseDTO carritoResponse = CarritoResponseDTO.builder()
                .id(carrtioSaved.getId())
                .usuario(carrtioSaved.getUsuario().getNombre())
                .detallesCarrito(detalleCarritoResponses)
                .total(carrtioSaved.getTotal())
                .fechaCreacion(carrtioSaved.getFechaCreacion())
                .status(carrtioSaved.getStatus())
                .build();


        return ResponseEntity.ok(carritoResponse);
    }
}