package com.example.carritodorado.service;

import com.example.carritodorado.model.Categoria;

import java.util.List;

public interface CategoriaService {

    Categoria create(Categoria categoria);

    List<Categoria> getAll();

    Categoria findById(Long id);

    void delete(Long id);

}
