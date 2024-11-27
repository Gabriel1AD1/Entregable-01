package com.entel.infra.adapter.input;

import com.entel.domain.models.Aeropuerto;
import com.entel.domain.repository.AeropuertoRepository;

import java.util.HashMap;
import java.util.Map;

// Implementación del Repositorio de Aeropuerto
public class AeropuertoRepositoryImpl implements AeropuertoRepository {

    private final Map<String, Aeropuerto> aeropuertosDB = new HashMap<>();  // Base de datos en memoria

    @Override
    public Aeropuerto findById(String idAeropuerto) {
        return aeropuertosDB.get(idAeropuerto);
    }

    @Override
    public void save(Aeropuerto aeropuerto) {
        aeropuertosDB.put(aeropuerto.getIdAeropuerto(), aeropuerto);
    }

    @Override
    public void update(Aeropuerto aeropuerto) {
        aeropuertosDB.put(aeropuerto.getIdAeropuerto(), aeropuerto);
    }

    @Override
    public void delete(String idAeropuerto) {
        aeropuertosDB.remove(idAeropuerto);
    }
}
