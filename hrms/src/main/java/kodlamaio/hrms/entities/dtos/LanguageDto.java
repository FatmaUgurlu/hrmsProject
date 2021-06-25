package kodlamaio.hrms.entities.dtos;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LanguageDto {

	private int resumeId;
	private String language;
	private char languageLevel;
	private Date createdDate;
}
