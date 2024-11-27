package com.entel.app.usecase;

import com.entel.domain.models.Reserva;
import com.entel.domain.repository.ReservaRepository;

// Capa de Aplicación
public class CancelarReservaService {

    private final ReservaRepository reservaRepository;

    // Inyección de dependencias
    public CancelarReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    // Método para cancelar la reserva
    public void cancelarReserva(String idReserva) {
        Reserva reserva = reservaRepository.findById(idReserva);
        if (reserva != null) {
            reserva.setEstado("Cancelada");
            reservaRepository.save(reserva);
        }
    }
}
