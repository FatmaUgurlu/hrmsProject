package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.ConfirmEmployer;

@Repository
public interface ConfirmEmployerDao extends JpaRepository <ConfirmEmployer, Integer>{

	ConfirmEmployer getByEmployerId(int id);
	boolean existsByEmployerId(int id);
}
