package com.entel.infra.adapter.input;

import com.entel.domain.models.Pago;
import com.entel.domain.repository.PagoRepository;

import java.util.HashMap;
import java.util.Map;

// Implementación del Repositorio de Pago
public class PagoRepositoryImpl implements PagoRepository {

    private final Map<String, Pago> pagosDB = new HashMap<>();  // Base de datos en memoria

    @Override
    public Pago findByReservaId(String idReserva) {
        return pagosDB.values().stream()
                .filter(pago -> pago.getIdReserva().equals(idReserva))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(Pago pago) {
        pagosDB.put(pago.getIdPago(), pago);
    }

    @Override
    public void update(Pago pago) {
        pagosDB.put(pago.getIdPago(), pago);
    }

    @Override
    public void delete(String idPago) {
        pagosDB.remove(idPago);
    }
}
