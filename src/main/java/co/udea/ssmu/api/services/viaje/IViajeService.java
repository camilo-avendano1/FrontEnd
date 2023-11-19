package co.udea.ssmu.api.services.viaje;

import co.udea.ssmu.api.model.jpa.model.Viaje;

import java.util.List;

public interface IViajeService {
    public Viaje crearViaje(Viaje viaje);
    public List<Viaje> obtenerViajes();
}
