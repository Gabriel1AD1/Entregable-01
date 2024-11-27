package com.entel.domain.repository;

import com.entel.domain.models.Itinerario;

// Interfaz del Repositorio para Itinerario
public interface ItinerarioRepository {

    // Encontrar itinerarios por criterio
    Itinerario findByCriteria(String idVuelo, String fechaInicio, String fechaFin);

    // Guardar un itinerario
    void save(Itinerario itinerario);

    // Actualizar un itinerario
    void update(Itinerario itinerario);

    // Eliminar un itinerario
    void delete(String idItinerario);
}
