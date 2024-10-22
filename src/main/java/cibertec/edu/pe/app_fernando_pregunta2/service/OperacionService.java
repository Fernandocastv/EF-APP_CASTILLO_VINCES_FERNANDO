package cibertec.edu.pe.app_fernando_pregunta2.service;

import org.springframework.stereotype.Service;


@Service
public class OperacionService {


    public String prendasDisponibles(Integer prendas) {
        if(prendas < 1) {
            throw new RuntimeException("No hay prendas disponibles.");
        } else {
            int random = (int) (Math.random() * 21);
            return "prendas disponibles: " + random;
        }
    }
}
