package com.example.carritodorado.service;

import com.example.carritodorado.model.Usuario;

import java.util.List;

public interface UsuarioService {

    Usuario crear(Usuario usuario);

    List<Usuario> getAll();

    Usuario findById(Long id);
}
