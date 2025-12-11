package com.example.carritodorado.service;

import com.example.carritodorado.dto.ProductoDTORequest;
import com.example.carritodorado.model.Producto;

import java.util.List;

public interface ProductoService {

    List<Producto> findAll();

    Producto findById(Long productId);

    Producto create(ProductoDTORequest producto);

    Producto update(Long productId, Producto producto);

    Producto disableById(Long productId);
}
