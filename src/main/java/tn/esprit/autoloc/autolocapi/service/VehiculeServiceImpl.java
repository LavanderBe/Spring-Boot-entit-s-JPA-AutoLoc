package tn.esprit.autoloc.autolocapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.autolocapi.domain.Vehicule;
import tn.esprit.autoloc.autolocapi.exception.ResourceNotFoundException;
import tn.esprit.autoloc.autolocapi.repository.IVehiculeRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class VehiculeServiceImpl implements IVehiculeService{
    private final IVehiculeRepository vehciculeRepository;
    @Override
    public Vehicule create(Vehicule vehicule) {
        if (vehicule.getIdVehicule() != null) {
            throw new IllegalArgumentException(
                    "Un nouveau vehicule ne doit pas avoir d'identifiant");
        }
        return vehciculeRepository.save(vehicule);
    }
    @Override
    public Vehicule findById(Long id) {
        return vehciculeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicule", id));
    }
    @Override
    public List<Vehicule> findAll() {
        return vehciculeRepository.findAll();
    }
    @Override
    public Vehicule update(Long id, Vehicule vehicule) {
        Vehicule existant = findById(id);

        existant.setImmatriculation(vehicule.getImmatriculation());
        existant.setMarque(vehicule.getMarque());
        existant.setModele(vehicule.getModele());
        existant.setCategorie(vehicule.getCategorie());
        existant.setTarifJournalier(vehicule.getTarifJournalier());
        existant.setStatut(vehicule.getStatut());
        existant.setAgence(vehicule.getAgence());
        existant.setEquipements(vehicule.getEquipements());
        return vehciculeRepository.save(existant);
    }
    @Override
    public void deleteById(Long id) {
        if (!vehciculeRepository.existsById(id)) {
            throw new ResourceNotFoundException("Vehicule", id);
        }
        vehciculeRepository.deleteById(id);
    }
}
