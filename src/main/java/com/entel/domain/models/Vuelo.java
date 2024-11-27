package com.entel.domain.models;

import lombok.Data;

@Data
public class Vuelo {
    private String idVuelo;
    private String aerolinea;
    private String origen;
    private String destino;
    private String fechaYHora;
    private double precio;
    private int capacidadPasajeros;

}
