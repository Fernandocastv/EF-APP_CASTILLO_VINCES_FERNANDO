package cibertec.edu.pe.app_fernando_pregunta2.controller;

import cibertec.edu.pe.app_fernando_pregunta2.service.OperacionService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/prueba")
@RequiredArgsConstructor
public class OperacionController {

    private final OperacionService operacionService;

    @GetMapping("/{prendas}/disponibles")
    @CircuitBreaker(name = "Fernando", fallbackMethod = "fallBackMethodNoExistenPrendas")
    public String prendasDisponibles(@PathVariable("prendas") Integer prendas) {
        return operacionService.prendasDisponibles(prendas);
    }

    public String fallBackMethodNoExistenPrendas(Integer prendas, Throwable throwable) {
        return "Prendas no disponibles.";
    }

}
