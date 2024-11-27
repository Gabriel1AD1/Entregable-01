package com.entel.app.usecase;

import com.entel.domain.models.Vuelo;
import com.entel.domain.repository.VueloRepository;
import lombok.AllArgsConstructor;

// Capa de Aplicación
@AllArgsConstructor
public class ActualizarDisponibilidadService {

    private VueloRepository vueloRepository;

    // Inyección de dependencias
    public void actualizarDisponibilidadService(VueloRepository vueloRepository) {
        this.vueloRepository = vueloRepository;
    }
    // Método para actualizar la disponibilidad
    public void actualizarDisponibilidad(String idVuelo, int nuevosAsientosDisponibles) {
        Vuelo vuelo = vueloRepository.findById(idVuelo);
        if (vuelo != null) {
            vuelo.setCapacidadPasajeros(nuevosAsientosDisponibles);
            vueloRepository.save(vuelo); // Guarda el vuelo con la nueva capacidad
        }
    }
}
