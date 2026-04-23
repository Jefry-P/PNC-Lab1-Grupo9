package com.bsaa.bow;

import com.bsaa.bow.model.Bow;
import com.bsaa.bow.service.BowService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Lab1ActividadBowApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lab1ActividadBowApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(BowService service) {
        return args -> {

            System.out.println("=== FILTRO POR VIRUS T-Virus ===");
            imprimir(service.filtrarPorVirus("T-Virus"));

            System.out.println("\n=== FILTRO POR ESTADO: En libertad ===");
            imprimir(service.filtrarPorEstado("En libertad"));

            System.out.println("\n=== VIRUS ACTIVOS SIN REPETICIÓN ===");
            service.virusActivosSinRepetir()
                    .forEach(v -> System.out.println("[S.T.A.R.S-REPORT] Virus activo: " + v));
        };
    }

    private void imprimir(List<Bow> lista) {
        lista.forEach(b -> System.out.println(
                "[S.T.A.R.S-REPORT] Nombre: " + b.getNombre() +
                        " | Nivel de Peligro: " + b.getNivelPeligro() +
                        " | Punto Débil: " + b.getPuntoDebil()
        ));
    }

}
