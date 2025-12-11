package com.example.carritodorado.service;

import lombok.RequiredArgsConstructor;
import com.example.carritodorado.dto.ProductoDTORequest;
import com.example.carritodorado.model.Categoria;
import com.example.carritodorado.model.Producto;
import com.example.carritodorado.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService{

    private final ProductoRepository productoRepository;


    @Override
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    @Override
    public Producto findById(Long productId) {
        return productoRepository.findById(productId).orElse(null);
    }

    @Override
    public Producto create(ProductoDTORequest producto) {
        if(producto.getId() == null){
            Categoria categoria = new Categoria(producto.getCategoriaId());

            Producto productoToSave = new Producto();
            productoToSave.setCategory(categoria);
            productoToSave.setDescripcion(producto.getDescripcion());
            productoToSave.setPrecio(producto.getPrecio());
            productoToSave.setNombre(producto.getNombre());


            return productoRepository.save(productoToSave);
        }
        return null;



    }

    @Override
    public Producto update(Long productId, Producto producto) {
        return null;
    }

    @Override
    public Producto disableById(Long productId) {
        return null;
    }
}