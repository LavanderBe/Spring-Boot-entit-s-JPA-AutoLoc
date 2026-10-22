package tn.esprit.autoloc.autolocapi.service;

import tn.esprit.autoloc.autolocapi.domain.Vehicule;

import java.util.List;

public interface IVehiculeService {
    Vehicule create(Vehicule contrat);
    Vehicule findById(Long id);
    List<Vehicule> findAll();
    Vehicule update(Long id, Vehicule contrat);
    void deleteById(Long id);
}
