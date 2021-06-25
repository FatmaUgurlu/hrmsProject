package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.core.cloudinary.CloudinaryService;
import kodlamaio.hrms.core.dtoConverter.DtoConverterService;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.core.results.SuccessDataResult;
import kodlamaio.hrms.core.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ResumeDao;
import kodlamaio.hrms.entities.concretes.Resume;
import kodlamaio.hrms.entities.dtos.ResumeAddDto;
import kodlamaio.hrms.entities.dtos.ResumeGetDto;

@Service
public class ResumeManager implements ResumeService {
	
	private ResumeDao resumeDao;
	private DtoConverterService dtoConverterService;
	private CloudinaryService cloudinaryService;

	@Autowired
	public ResumeManager(kodlamaio.hrms.dataAccess.abstracts.ResumeDao resumeDao,
			DtoConverterService dtoConverterService, CloudinaryService cloudinaryService) {
		super();
		this.resumeDao = resumeDao;
		this.dtoConverterService = dtoConverterService;
		this.cloudinaryService = cloudinaryService;
	}


	

	@Override
	public Result add(ResumeAddDto resumeAddDto) {
		resumeDao.save((Resume) dtoConverterService.dtoClassConverter(resumeDao, Resume.class));
		return new SuccessResult("Başarıyla eklendi.");
	}

	@Override
	public DataResult<List<ResumeGetDto>> getAll() {
		
		return new SuccessDataResult<List<ResumeGetDto>>(dtoConverterService.dtoConverter(resumeDao.findAll(), ResumeGetDto.class),"Data listelendi.");
	}

	@Override
	public DataResult<List<ResumeGetDto>> findAllByCandidateId(int id) {
		
		return new SuccessDataResult<List<ResumeGetDto>>(dtoConverterService.dtoConverter(resumeDao.findAllByCandidateId(id), ResumeGetDto.class),"Data listelemdi.");
	}

	@Override
	public Result saveImage(MultipartFile file, int resumeId) {
		
		@SuppressWarnings("unchecked")
		Map<String, String> uploader = (Map<String, String>) cloudinaryService.save(file).getData();
		String imageUrl = uploader.get("url");
		Resume Cv = resumeDao.getOne(resumeId);
		Cv.setPhoto(imageUrl);
		resumeDao.save(Cv);
		return new SuccessResult("Profil resmi eklenmiştir.");
	}

}
