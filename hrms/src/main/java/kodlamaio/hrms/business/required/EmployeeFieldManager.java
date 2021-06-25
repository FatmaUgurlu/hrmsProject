package kodlamaio.hrms.business.required;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.FieldService;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.ErrorResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.core.results.SuccessDataResult;
import kodlamaio.hrms.core.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.Employee;

@Service
public class EmployeeFieldManager implements FieldService<Employee>{

	private EmployeeDao employeeDao;
	private UserDao userDao;
	
	@Autowired
	public EmployeeFieldManager(EmployeeDao employeeDao, UserDao userDao) {
		super();
		this.employeeDao = employeeDao;
		this.userDao = userDao;
	}


	@Override
	public Result verifyData(Employee employee) {
		
		if(this.userDao.existsByMail(employee.getMail())) {
			return new ErrorResult("Farklı bir mail adresi ile kayıt olunuz.");
		}
		
		employee.setVerify(true);
		this.employeeDao.save(employee);
		return new SuccessResult("Kayıt başarılı bir şekilde yapılmıştır.");
		
	}

	
	@Override
	public DataResult<List<Employee>> getall() {
		
		return new SuccessDataResult<List<Employee>>(this.employeeDao.findAll(),"Listeleme yapıldı.");
	}
}
