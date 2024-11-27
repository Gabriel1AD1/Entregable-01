package com.entel.domain.models;
import lombok.Data;

@Data
public class Usuario {
    private String idUsuario;
    private String nombre;
    private String dni;
    private String nacionalidad;
    private String fechaNac;
    private String correo;
    private String password;
    private String idVuelo;

    public Usuario(String password, String nombre) {
        this.password = password;
        this.nombre = nombre;
    }
}
