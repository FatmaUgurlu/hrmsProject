package kodlamaio.hrms.entities.dtos;

import java.sql.Date;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TechnologyDto {

	@JsonIgnore
	private int id;
	private int resumeId;
	@NotBlank(message="Teknoloji açıklaması eklenmesi zorunludur.")
	private String description;
	private Date createdDate;
}
