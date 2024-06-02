package bircan.io.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import bircan.io.rentACar.entities.concretes.Brand;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
	boolean existsByName(String name);
}
