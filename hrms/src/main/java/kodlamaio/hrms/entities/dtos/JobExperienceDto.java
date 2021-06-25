package kodlamaio.hrms.entities.dtos;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobExperienceDto {
	
	@JsonIgnore
	private int id;
	private int resumeId;
	private String companyName;
	private Date startedDate;
	private Date endedDate;
	private Date createdDate;
	

}
