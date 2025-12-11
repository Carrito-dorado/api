package com.example.carritodorado.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "detalle_carrito")
@Getter
@Setter
public class DetalleCarrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carrito_id", nullable = false)  // Relación con Carrito
    private Carrito carrito;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto_id", nullable = false)  // Relación con Producto
    private Producto producto;

    private Integer cantidad;

    private Double precio;

    private Double total;

    public Double getTotal(Double line) {
        Double t = 0d;
        this.precio = producto.getPrecio();
        total = producto.getPrecio() * line;
        return t;

    }






}
