package com.example.carritodorado.service;

import com.example.carritodorado.model.Usuario;
import com.example.carritodorado.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UsuarioServiceImpl implements UsuarioService{

    private final UsuarioRepository usuariosRepository;


    @Override
    public Usuario crear(Usuario usuario) {
        return usuariosRepository.save(usuario);
    }

    @Override
    public List<Usuario> getAll() {
        return usuariosRepository.findAll();
    }

    @Override
    public Usuario findById(Long id) {
        return usuariosRepository.findById(id).orElse(null);
    }
}


