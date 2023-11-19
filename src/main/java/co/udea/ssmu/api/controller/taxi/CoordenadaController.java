package co.udea.ssmu.api.controller.taxi;

import co.udea.ssmu.api.model.jpa.model.Coordenadas;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class CoordenadaController {
    @MessageMapping("/taxi")
    @SendTo("/taxi/coordenada")
    public Coordenadas envioCoordenada(Coordenadas coordenada) throws Exception {
        return coordenada;
    }

}

