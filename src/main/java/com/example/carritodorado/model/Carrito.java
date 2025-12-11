package com.example.carritodorado.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "carrito")
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer status; //activo->1, completado ->2,cancelado ->3

    private LocalDateTime fechaCreacion;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToMany(mappedBy = "carrito", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DetalleCarrito> detallesCarrito;

    private Double total;

    @PrePersist
    public void prePersist() {
        // Asigna la fecha y hora actual antes de la inserción
        this.fechaCreacion = LocalDateTime.now();
    }



}