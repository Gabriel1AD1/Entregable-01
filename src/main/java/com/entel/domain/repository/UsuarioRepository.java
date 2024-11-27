package com.entel.domain.repository;

import com.entel.domain.models.Usuario;

// Dominio
public interface UsuarioRepository {
    Usuario findByUsername(String username);
}
