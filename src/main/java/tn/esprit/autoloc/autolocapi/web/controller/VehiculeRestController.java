package tn.esprit.autoloc.autolocapi.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.autolocapi.domain.Vehicule;
import tn.esprit.autoloc.autolocapi.service.VehiculeServiceImpl;


@RequiredArgsConstructor
@RestController
@RequestMapping("Vehicules")

public class VehiculeRestController {
    private final VehiculeServiceImpl vehiculeServicesImlp;
    @PostMapping
    public Vehicule add(@RequestBody Vehicule vehicule) {
        return vehiculeServicesImlp.create(vehicule);
    }
    @GetMapping("/{id}")
    public Vehicule getVehiculeById(@PathVariable Long id) {
        return vehiculeServicesImlp.findById(id);
    }
    @PutMapping("/{id}")
    public Vehicule update(@PathVariable Long id, @RequestBody Vehicule vehicule) {
        vehicule.setIdVehicule(id);
        return vehiculeServicesImlp.update(id,vehicule);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        vehiculeServicesImlp.deleteById(id);
    }
}
