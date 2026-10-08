package tn.esprit.autoloc.autolocapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.autoloc.autolocapi.domain.Employe;

public interface IEmployeRepository extends JpaRepository<Employe,Long> {
}
