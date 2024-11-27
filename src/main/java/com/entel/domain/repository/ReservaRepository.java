package com.entel.domain.repository;

import com.entel.domain.models.Reserva;

// Interfaz del Repositorio para Reserva
public interface ReservaRepository {

    // Encontrar una reserva por ID
    Reserva findById(String idReserva);

    // Guardar una reserva
    void save(Reserva reserva);

    // Actualizar una reserva
    void update(Reserva reserva);

    // Eliminar una reserva
    void delete(String idReserva);
}
