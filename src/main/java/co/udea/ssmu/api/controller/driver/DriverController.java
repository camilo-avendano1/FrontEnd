package co.udea.ssmu.api.controller.driver;

import co.udea.ssmu.api.model.jpa.model.Conductor;
import co.udea.ssmu.api.services.driver.IDriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/driver")

public class DriverController {

    @Autowired
    private IDriverService driverService;

    @GetMapping("/{id}")
    public ResponseEntity<Conductor> getDriverById(@PathVariable Long id) {
        Conductor conductor = this.driverService.getDriverById(id);
        if(conductor == null)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(conductor, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<HttpStatus> createDriver(@RequestBody Conductor conductor) {
        Conductor conductorCreated = this.driverService.createDriver(conductor);
        if (conductorCreated == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
