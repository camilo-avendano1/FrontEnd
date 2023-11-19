package co.udea.ssmu.api.component;

import co.udea.ssmu.api.model.jpa.model.Coordenadas;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommandLineInit implements CommandLineRunner {

        @Override
        public void run(String... args) throws Exception {
            List<Coordenadas> coordenadas = new ArrayList<>();
            coordenadas.add(new Coordenadas(0,0));
        }
}
