package com.entel.app.usecase;

import com.entel.domain.models.Aeropuerto;
import com.entel.domain.repository.AeropuertoRepository;

// Capa de Aplicación
public class OrigenAeropuertoService {

    private final AeropuertoRepository aeropuertoRepository;

    // Inyección de dependencias
    public OrigenAeropuertoService(AeropuertoRepository aeropuertoRepository) {
        this.aeropuertoRepository = aeropuertoRepository;
    }

    // Método para obtener el aeropuerto de origen
    public Aeropuerto obtenerAeropuertoOrigen(String idVuelo) {
        return aeropuertoRepository.findById(idVuelo);
    }
}
