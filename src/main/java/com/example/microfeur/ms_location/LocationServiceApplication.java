package com.example.microfeur.ms_location;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LocationServiceApplication {

    /*
    — POST /locations : enregistrer une localisation pour un userId donné (latitude, longitude, date/heure).
    — GET /locations/{id} : lire une localisation.
    — GET /locations?userId=.
     */

    public static void main(String[] args) {
        SpringApplication.run(LocationServiceApplication.class, args);
    }

}
