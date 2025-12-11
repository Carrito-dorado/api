package com.example.carritodorado.service;

import com.example.carritodorado.model.Categoria;
import com.example.carritodorado.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    @Override
    public Categoria create(Categoria categoria) {

        findById(categoria.getId());
        return categoriaRepository.save(categoria);


    }

    @Override
    public List<Categoria> getAll() {
        return categoriaRepository.findAll();

    }

    @Override
    public Categoria findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
