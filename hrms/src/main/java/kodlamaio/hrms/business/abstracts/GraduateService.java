package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.concretes.Graduate;

public interface GraduateService {

	Result add(Graduate graduate);
	DataResult<List<Graduate>> getAll();
}
