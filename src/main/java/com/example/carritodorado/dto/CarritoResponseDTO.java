package com.example.carritodorado.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CarritoResponseDTO {


    private Long id;

    private Integer status; //activo->1, completado ->2,cancelado ->3

    private LocalDateTime fechaCreacion;


    private String usuario;

    private List<DetalleCarritoResponse> detallesCarrito;

    private Double total;
}
