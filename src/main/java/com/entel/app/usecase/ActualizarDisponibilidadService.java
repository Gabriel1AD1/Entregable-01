package com.entel.app.usecase;

import com.entel.app.port.out.ActualizarDisponibilidadService;
import com.entel.domain.models.Vuelo;
import com.entel.domain.repository.VueloRepository;
import lombok.AllArgsConstructor;

// Capa de Aplicación
@AllArgsConstructor
public class ActualizarDisponibilidadServiceImpl {

    private VueloRepository vueloRepository;

    // Inyección de dependencias
    public void ActualizarDisponibilidadService(VueloRepository vueloRepository) {
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
