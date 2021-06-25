package kodlamaio.hrms.core.cloudinary;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.results.DataResult;

public interface CloudinaryService {

	DataResult<?> save(MultipartFile file);
}
