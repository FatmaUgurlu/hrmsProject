package kodlamaio.hrms.business.concretes;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.business.abstracts.FieldService;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;

import kodlamaio.hrms.entities.concretes.Employee;

@Service
public class EmployeeManager implements EmployeeService{
	
	private FieldService<Employee> fieldService;

	@Autowired
	public EmployeeManager(FieldService<Employee> fieldService) {
		super();
		this.fieldService = fieldService;
	}

	@Override
	public DataResult<List<Employee>> getAll() {
		return fieldService.getall();
	}

	@Override
	public Result add(Employee employee) {
		
		return this.fieldService.verifyData(employee);
	}

	
}
