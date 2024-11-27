package com.entel.app.usecase;

import com.entel.domain.models.Aeropuerto;
import com.entel.domain.repository.AeropuertoRepository;

// Capa de Aplicación
public class DestinoAeropuertoService {

    private final AeropuertoRepository aeropuertoRepository;

    // Inyección de dependencias
    public DestinoAeropuertoService(AeropuertoRepository aeropuertoRepository) {
        this.aeropuertoRepository = aeropuertoRepository;
    }

    // Método para obtener el aeropuerto de destino
    public Aeropuerto obtenerAeropuertoDestino(String idVuelo) {
        return aeropuertoRepository.findById(idVuelo);
    }
}
