package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@Repository
public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{

	List<JobAdvertisementDao> findByIsActive(boolean status);
	List<JobAdvertisementDao> findByIsActiveOrderByClosedDate(boolean status);
	List<JobAdvertisementDao> findByIsActiveAndEmployer_CompanyName(boolean status, String companyName);
}
