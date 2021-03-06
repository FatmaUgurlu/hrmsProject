package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.dtos.TechnologyDto;

public interface TechnologyService {

	Result add(TechnologyDto technologyDto);
	DataResult<List<TechnologyDto>> getAll();
}
