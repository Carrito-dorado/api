package com.example.carritodorado.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Table(name = "usuarios")
@Entity
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String telefono;

    private String direccion;

    private String correo;

    private String password;

    private Integer rol;// cliente ->1, repartidor -> 2, admin ->3

    private LocalDateTime fechaRegistro;

    @PrePersist
    public void prePersist() {
        // Asigna la fecha y hora actual antes de la inserción
        this.fechaRegistro = LocalDateTime.now();
    }




}