package com.entel.app.usecase;

import com.entel.domain.models.Vuelo;
import com.entel.domain.repository.VueloRepository;

// Capa de Aplicación
public class VerificarCapacidadService {

    private final VueloRepository vueloRepository;

    // Inyección de dependencias
    public VerificarCapacidadService(VueloRepository vueloRepository) {
        this.vueloRepository = vueloRepository;
    }

    // Método para verificar capacidad
    public boolean verificarCapacidad(String idVuelo, int cantidadPasajeros) {
        Vuelo vuelo = vueloRepository.findById(idVuelo);
        return vuelo != null && vuelo.getCapacidadPasajeros() >= cantidadPasajeros;
    }
}
