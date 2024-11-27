package com.entel.domain.models;

import lombok.Data;

@Data
public class Pago {
    private String idPago;
    private String idReserva;
    private double monto;
    private String metodoPago;

    public Pago(String idReserva, double monto, String metodoPago) {
    }
}
