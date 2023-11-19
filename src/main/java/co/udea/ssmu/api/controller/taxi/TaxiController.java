package co.udea.ssmu.api.controller.taxi;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.messaging.simp.SimpMessagingTemplate;

@RestController
@RequestMapping("/taxiapp")

public class TaxiController {
    private final SimpMessagingTemplate template;


    public TaxiController(SimpMessagingTemplate template) {
        this.template = template;
    }


    @PostMapping("/send-coordenada")
    public void sendCoordenada(@RequestBody String coordenada) {
        this.template.convertAndSend("/taxi/coordenada", coordenada);
    }

}
