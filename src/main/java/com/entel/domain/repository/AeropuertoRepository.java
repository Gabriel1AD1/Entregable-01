package com.entel.domain.repository;

import com.entel.domain.models.Aeropuerto;

// Interfaz del Repositorio para Aeropuerto
public interface AeropuertoRepository {

    // Encontrar aeropuerto por ID
    Aeropuerto findById(String idAeropuerto);

    // Guardar un aeropuerto
    void save(Aeropuerto aeropuerto);

    // Actualizar aeropuerto
    void update(Aeropuerto aeropuerto);

    // Eliminar aeropuerto
    void delete(String idAeropuerto);
}
