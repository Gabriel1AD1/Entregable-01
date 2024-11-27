package com.entel.domain.service;

import com.entel.domain.models.Usuario;
import com.entel.domain.repository.UsuarioRepository;

import java.util.Objects;

// Dominio
public class LoginService {

    private final UsuarioRepository usuarioRepository;

    public LoginService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public boolean login(String username, String password) {
        Usuario usuario = usuarioRepository.findByUsername(username);
        System.out.println(usuario);
        if (usuario != null) {
            return Objects.equals(usuario.getPassword(), password);
        }
        return false;
    }
}
