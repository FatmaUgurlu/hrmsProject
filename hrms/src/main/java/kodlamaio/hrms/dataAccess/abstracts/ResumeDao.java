package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.Resume;

@Repository
public interface ResumeDao extends JpaRepository<Resume,Integer>{

	List<Resume> findAllByCandidateId(int id);
}
