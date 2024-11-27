package com.entel.domain.models;

import lombok.Data;

@Data
public class Reserva {
    private String idReserva;
    private String idUsuario;
    private String idVuelo;
    private String estado;

    public Reserva(String idUsuario, String idVuelo, String pendiente) {
    }
}
