package com.entel.infra.adapter.input;

import com.entel.domain.models.Itinerario;
import com.entel.domain.repository.ItinerarioRepository;

import java.util.HashMap;
import java.util.Map;

// Implementación del Repositorio de Itinerario
public class ItinerarioRepositoryImpl implements ItinerarioRepository {

    private final Map<String, Itinerario> itinerariosDB = new HashMap<>();  // Base de datos en memoria

    @Override
    public Itinerario findByCriteria(String idVuelo, String fechaInicio, String fechaFin) {
        return itinerariosDB.values().stream()
                .filter(itinerario -> itinerario.getIdItinerario().equals(idVuelo)
                        && itinerario.getFechaInicio().equals(fechaInicio)
                        && itinerario.getFechaFin().equals(fechaFin))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(Itinerario itinerario) {
        itinerariosDB.put(itinerario.getIdItinerario(), itinerario);
    }

    @Override
    public void update(Itinerario itinerario) {
        itinerariosDB.put(itinerario.getIdItinerario(), itinerario);
    }

    @Override
    public void delete(String idItinerario) {
        itinerariosDB.remove(idItinerario);
    }
}
