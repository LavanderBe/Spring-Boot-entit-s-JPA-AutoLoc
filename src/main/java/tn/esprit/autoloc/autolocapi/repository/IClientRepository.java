package tn.esprit.autoloc.autolocapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.autoloc.autolocapi.domain.Client;

public interface IClientRepository extends JpaRepository<Client,Long> {
}
