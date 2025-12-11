package com.example.carritodorado.controller;


import lombok.RequiredArgsConstructor;
import com.example.carritodorado.dto.ProductoDTORequest;
import com.example.carritodorado.model.Producto;
import com.example.carritodorado.service.ProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;

    @GetMapping
    public ResponseEntity<List<Producto>> getAll(){
        return ResponseEntity.ok(productoService.findAll());
    }

    @PostMapping
    public ResponseEntity<Producto> create(@RequestBody ProductoDTORequest productoDTORequest){
        return ResponseEntity.ok(productoService.create(productoDTORequest));

    }
}