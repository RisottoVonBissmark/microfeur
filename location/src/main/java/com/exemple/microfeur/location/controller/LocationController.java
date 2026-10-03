package com.exemple.microfeur.location.controller;

import com.exemple.microfeur.location.model.Location;
import com.exemple.microfeur.location.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/locations")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @PostMapping
    public Location addLocation(@RequestBody Location location) {
        return locationService.enregistrerLocalisation(location);
    }

    @GetMapping("/{id}")
    public Optional<Location> getLocation(@PathVariable Integer id) {
        return locationService.getLocationById(id);
    }

    @GetMapping
    public List<Location> getLocations(@RequestParam Integer userId) {
        return locationService.getLocationsByUserId(userId);
    }
}