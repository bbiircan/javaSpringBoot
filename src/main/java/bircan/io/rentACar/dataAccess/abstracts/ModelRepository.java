package bircan.io.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import bircan.io.rentACar.entities.concretes.Model;

public interface ModelRepository extends JpaRepository<Model, Integer> {

}
