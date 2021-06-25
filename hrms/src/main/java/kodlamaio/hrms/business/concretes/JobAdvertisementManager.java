package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.dtoConverter.DtoConverterService;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.core.results.SuccessDataResult;
import kodlamaio.hrms.core.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementAddDto;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao jobAdvertisementDao;
	private DtoConverterService dtoConverterService;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao, DtoConverterService dtoConverterService) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
		this.dtoConverterService = dtoConverterService;
	}

	@Override
	public Result add(JobAdvertisementAddDto jobAdvertisementAddDto) {
		
		this.jobAdvertisementDao.save((JobAdvertisement) dtoConverterService.dtoClassConverter(jobAdvertisementAddDto, JobAdvertisement.class));
		return new SuccessResult("İş ilanınız eklenmiştir.");
	}

	@Override
	public Result delete(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.delete(jobAdvertisement);
		return new SuccessResult("İş ilanı pasif hale getirildi.");
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> findByIsActive() {
		
		return new SuccessDataResult<List<JobAdvertisementDto>>(dtoConverterService.dtoConverter(jobAdvertisementDao.findByIsActive(true), JobAdvertisementDto.class),"Aktif iş ilanları listelendi."); 
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> findByIsActiveOrderByClosedDate() {
		
		return new SuccessDataResult<List<JobAdvertisementDto>>(this.dtoConverterService.dtoConverter(jobAdvertisementDao.findByIsActiveOrderByClosedDate(true), JobAdvertisementDto.class),"Data listelendi.");
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> findByIsActiveAndEmployer_CompanyName(String companyName) {
		
		return new SuccessDataResult<List<JobAdvertisementDto>>(this.dtoConverterService.dtoConverter(jobAdvertisementDao.findByIsActiveAndEmployer_CompanyName(true, companyName), JobAdvertisementDto.class),
				"firmanın aktif iş ilanları listelendi.");
	}

}
