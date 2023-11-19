package co.udea.ssmu.api.services.driver;

import co.udea.ssmu.api.model.jpa.model.Conductor;
import co.udea.ssmu.api.model.jpa.repository.ConductorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverServiceImp implements IDriverService {

    @Autowired
    private ConductorRepository conductorRepository;

    @Override
    public Conductor getDriverById(Long id) {
        return this.conductorRepository.findById(id).orElse(null);
    }

    @Override
    public Conductor createDriver(Conductor conductor) {
        System.out.println(conductor.toString());
        try {
            this.conductorRepository.save(conductor);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return conductor;
    }
}
