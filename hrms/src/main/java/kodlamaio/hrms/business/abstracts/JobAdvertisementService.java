package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementAddDto;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

public interface JobAdvertisementService {

	Result add(JobAdvertisementAddDto jobAdvertisementAddDto);
	Result delete(JobAdvertisement jobAdvertisement);
	DataResult<List<JobAdvertisementDto>> findByIsActive();
	DataResult<List<JobAdvertisementDto>> findByIsActiveOrderByClosedDate();
	DataResult<List<JobAdvertisementDto>> findByIsActiveAndEmployer_CompanyName(String companyName);
}
