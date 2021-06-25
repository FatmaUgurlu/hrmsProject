package kodlamaio.hrms.core.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hrms.core.cloudinary.CloudinaryManager;
import kodlamaio.hrms.core.cloudinary.CloudinaryService;

@Configuration
public class CloudinaryConfig {
	
	
	 	@Bean
	    public Cloudinary cloudinaryUser(){
	        return new Cloudinary(ObjectUtils.asMap(
	                "cloud_name", "fatmaugurlu",
	                "api_key", "919683667585387",
	                "api_secret", "3VukGLeubr9Yh0UXrdAJk6_rdzo"));
	    }

	    @Bean
	    public CloudinaryService cloudinaryService(){
	        return new CloudinaryManager(cloudinaryUser());
	    }

}