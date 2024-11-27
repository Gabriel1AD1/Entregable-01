package com.entel.app.usecase;

import com.entel.domain.models.Reserva;
import com.entel.domain.models.Vuelo;
import com.entel.domain.repository.ReservaRepository;
import com.entel.domain.repository.VueloRepository;

// Capa de Aplicación
public class CrearReservaService {

    private final ReservaRepository reservaRepository;
    private final VueloRepository vueloRepository;

    // Inyección de dependencias
    public CrearReservaService(ReservaRepository reservaRepository, VueloRepository vueloRepository) {
        this.reservaRepository = reservaRepository;
        this.vueloRepository = vueloRepository;
    }

    // Método para crear la reserva
    public void crearReserva(String idUsuario, String idVuelo) {
        Vuelo vuelo = vueloRepository.findById(idVuelo);
        if (vuelo != null) {
            Reserva reserva = new Reserva(idUsuario, idVuelo, "Pendiente");
            reservaRepository.save(reserva);
        }
    }
}
