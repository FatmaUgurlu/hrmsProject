package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer>{

	Employee getByNameAndSurname(String name, String surname);
	boolean existsByNameAndSurname(String name, String surname);
}
