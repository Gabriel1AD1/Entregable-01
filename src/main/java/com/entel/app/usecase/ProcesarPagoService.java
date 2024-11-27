package com.entel.app.usecase;

import com.entel.domain.models.Pago;
import com.entel.domain.repository.PagoRepository;

// Capa de Aplicación
public class ProcesarPagoService {

    private final PagoRepository pagoRepository;

    // Inyección de dependencias
    public ProcesarPagoService(PagoRepository pagoRepository) {
        this.pagoRepository = pagoRepository;
    }

    // Método para procesar el pago
    public void procesarPago(String idReserva, double monto, String metodoPago) {
        Pago pago = new Pago(idReserva, monto, metodoPago);
        pagoRepository.save(pago);
    }
}
