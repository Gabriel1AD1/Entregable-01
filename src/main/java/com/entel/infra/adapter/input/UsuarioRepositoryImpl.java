package com.entel.infra.adapter.input;

// Infraestructura
import com.entel.domain.models.Usuario;
import com.entel.domain.repository.UsuarioRepository;

import java.util.HashMap;
import java.util.Map;

public class UsuarioRepositoryImpl implements UsuarioRepository {

    private final Map<String, Usuario> usuarios = new HashMap<>();

    public UsuarioRepositoryImpl() {
        // Crear un usuario de ejemplo (en un caso real, esto vendría de una BD)
        usuarios.put("admin", new Usuario("admin", "password123"));
    }

    @Override
    public Usuario findByUsername(String username) {
        return usuarios.get(username);
    }
}
