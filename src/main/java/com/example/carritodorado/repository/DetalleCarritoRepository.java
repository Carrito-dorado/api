package com.example.carritodorado.repository;

import com.example.carritodorado.model.DetalleCarrito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleCarritoRepository extends JpaRepository<DetalleCarrito, Long> {
}
