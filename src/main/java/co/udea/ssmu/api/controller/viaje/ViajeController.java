package co.udea.ssmu.api.controller.viaje;



import co.udea.ssmu.api.model.jpa.model.Viaje;
import co.udea.ssmu.api.model.jpa.repository.ViajeRepository;
import co.udea.ssmu.api.services.viaje.IViajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/viajes")
public class ViajeController {
    @Autowired
    private IViajeService viajeService;

    @Autowired
    private ViajeRepository ubicacionRepository;


    @PostMapping
    public ResponseEntity<?> crearViaje(@RequestBody Viaje viaje){
        if (viaje == null)
            return ResponseEntity.badRequest().body("No se envio ningun viaje");

        return ResponseEntity.ok(viajeService.crearViaje(viaje));

    }



    @GetMapping
    public ResponseEntity<?> obtenerViajes(){
        return ResponseEntity.ok(viajeService.obtenerViajes());
    }


}
