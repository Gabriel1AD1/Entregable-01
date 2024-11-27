package com.entel.infra.adapter.input;

import com.entel.domain.models.Vuelo;
import com.entel.domain.repository.VueloRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// Implementación del Repositorio de Vuelo
public class VueloRepositoryImpl implements VueloRepository {

    private final Map<String, Vuelo> vuelosDB = new HashMap<>();  // Base de datos en memoria (para ejemplos)

    @Override
    public List<Vuelo> findVuelosByCriteria(String origen, String destino, String fecha) {
        return vuelosDB.values().stream()
                .filter(vuelo -> vuelo.getOrigen().equalsIgnoreCase(origen)
                        && vuelo.getDestino().equalsIgnoreCase(destino)
                        && vuelo.getFechaYHora().contains(fecha))
                .collect(Collectors.toList());
    }

    @Override
    public Vuelo findById(String idVuelo) {
        return vuelosDB.get(idVuelo);
    }

    @Override
    public void save(Vuelo vuelo) {
        vuelosDB.put(vuelo.getIdVuelo(), vuelo);
    }

    @Override
    public void update(Vuelo vuelo) {
        vuelosDB.put(vuelo.getIdVuelo(), vuelo);
    }

    @Override
    public void delete(String idVuelo) {
        vuelosDB.remove(idVuelo);
    }
}
