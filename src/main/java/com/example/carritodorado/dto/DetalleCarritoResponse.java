package com.example.carritodorado.dto;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class DetalleCarritoResponse {

    private Long id;

    private String nombreProducto;

    private Integer cantidad;

    private Double precio;

    private Double total;
}
