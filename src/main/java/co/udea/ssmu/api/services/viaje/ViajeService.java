package co.udea.ssmu.api.services.viaje;

import co.udea.ssmu.api.model.jpa.model.Viaje;
import co.udea.ssmu.api.model.jpa.repository.ViajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ViajeService implements IViajeService {

    @Autowired
    private ViajeRepository viajeRepository;
    @Override
    public Viaje crearViaje(Viaje viaje) {
        try {
            this.viajeRepository.save(viaje);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return viaje;
    }

    @Override
    public List<Viaje> obtenerViajes() {
        return this.viajeRepository.findAll();
    }
}
