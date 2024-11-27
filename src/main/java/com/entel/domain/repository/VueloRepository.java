package com.entel.domain.repository;

import com.entel.domain.models.Vuelo;

import java.util.ArrayList;
import java.util.List;

// Interfaz del Repositorio para Vuelo
public interface VueloRepository {

    // Encontrar vuelos por criterios
    List<Vuelo> findVuelosByCriteria(String origen, String destino, String fecha);

    // Encontrar un vuelo por su ID
    Vuelo findById(String idVuelo);

    // Guardar un vuelo
    void save(Vuelo vuelo);

    // Actualizar vuelo
    void update(Vuelo vuelo);

    // Eliminar un vuelo
    void delete(String idVuelo);
}
