package com.example.carritodorado.controller;


import lombok.RequiredArgsConstructor;
import com.example.carritodorado.model.Categoria;
import com.example.carritodorado.service.CategoriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService categoriaService;


    @GetMapping
    public ResponseEntity<List<Categoria>> getAll(){

        var categorias = categoriaService.getAll();
        return ResponseEntity.ok(categorias);
    }

    @PostMapping
    public ResponseEntity<Categoria> create(@RequestBody Categoria categoria){

        return new ResponseEntity<>(categoriaService.create(categoria), HttpStatus.CREATED );
    }
}