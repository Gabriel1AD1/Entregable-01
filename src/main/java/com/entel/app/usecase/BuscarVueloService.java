package com.entel.app.usecase;

import com.entel.app.port.out.BuscarVueloService;
import com.entel.domain.models.Vuelo;
import com.entel.domain.repository.VueloRepository;
import lombok.AllArgsConstructor;

import java.util.List;

// Capa de Aplicación
@AllArgsConstructor
public class BuscarVueloServiceImpl implements BuscarVueloService {

    private VueloRepository vueloRepository;

    // Inyección de dependencias
    public void BuscarVueloService(VueloRepository vueloRepository) {
        this.vueloRepository = vueloRepository;
    }

    // Método para buscar vuelos
    public List<Vuelo> buscarVuelos(String origen, String destino, String fecha) {
        return vueloRepository.findVuelosByCriteria(origen, destino, fecha);
    }
}
