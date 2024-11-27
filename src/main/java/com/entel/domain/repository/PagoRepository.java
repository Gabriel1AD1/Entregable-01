package com.entel.domain.repository;

import com.entel.domain.models.Pago;

// Interfaz del Repositorio para Pago
public interface PagoRepository {

    // Encontrar pago por ID de reserva
    Pago findByReservaId(String idReserva);

    // Guardar un pago
    void save(Pago pago);

    // Actualizar un pago
    void update(Pago pago);

    // Eliminar un pago
    void delete(String idPago);
}
