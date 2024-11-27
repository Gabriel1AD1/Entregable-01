package com.entel.infra.adapter.input;

import com.entel.domain.models.Reserva;
import com.entel.domain.repository.ReservaRepository;

import java.util.HashMap;
import java.util.Map;

// Implementación del Repositorio de Reserva
public class ReservaRepositoryImpl implements ReservaRepository {

    private final Map<String, Reserva> reservasDB = new HashMap<>();  // Base de datos en memoria

    @Override
    public Reserva findById(String idReserva) {
        return reservasDB.get(idReserva);
    }

    @Override
    public void save(Reserva reserva) {
        reservasDB.put(reserva.getIdReserva(), reserva);
    }

    @Override
    public void update(Reserva reserva) {
        reservasDB.put(reserva.getIdReserva(), reserva);
    }

    @Override
    public void delete(String idReserva) {
        reservasDB.remove(idReserva);
    }
}
