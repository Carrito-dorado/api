package com.example.carritodorado.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDTORequest {

    //@NotBlank(message = "Debe tener un nombre el producto")
    private Long id;

    private String nombre;

    private String descripcion;

    //@DecimalMin("0.01")
    private Double precio;

    //@Min(value = 1)
    private Long categoriaId;
}
