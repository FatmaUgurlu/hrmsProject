package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.VerifyCode;

public interface VerifyCodeDao extends JpaRepository<VerifyCode, Integer>{

	VerifyCode getByVerifyCode(String code);
	boolean existsByVerifyCode(String code);
}
