package tn.esprit.autoloc.autolocapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.autolocapi.domain.Paiement;
import tn.esprit.autoloc.autolocapi.exception.ResourceNotFoundException;
import tn.esprit.autoloc.autolocapi.repository.IPaiementRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PaiementServiceImpl implements IPaiementService {
    private final IPaiementRepository paiementRepository;

    @Override
    public Paiement create(Paiement paiement) {
        if (paiement.getIdPaiement() != null) {
            throw new IllegalArgumentException(
                    "Un nouveau paiement ne doit pas avoir d'identifiant");
        }
        return paiementRepository.save(paiement);
    }

    @Override
    public Paiement findById(Long id) {
        return paiementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Paiement", id));
    }

    @Override
    public List<Paiement> findAll() {
        return paiementRepository.findAll();
    }

    @Override
    public Paiement update(Long id, Paiement paiement) {
        Paiement existant = findById(id);

        existant.setMontant(paiement.getMontant());
        existant.setDatePaiement(paiement.getDatePaiement());
        existant.setModePaiement(paiement.getModePaiement());
        existant.setContrat(paiement.getContrat());

        return paiementRepository.save(existant);
    }

    @Override
    public void deleteById(Long id) {
        if (!paiementRepository.existsById(id)) {
            throw new ResourceNotFoundException("Paiement", id);
        }
        paiementRepository.deleteById(id);
    }
}
