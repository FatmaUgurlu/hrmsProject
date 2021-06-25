package kodlamaio.hrms.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="resume_langs")
@AllArgsConstructor
@NoArgsConstructor
public class Language {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne(targetEntity = Resume.class)
	@JoinColumn(name="resume_id")
	private  Resume resume;
	
	@NotBlank(message="Yabancı dil eklenmenmesi zorunludur.")
	@Column(name="language")
	private String language;
	
	@NotBlank(message="Dil seviyesi eklenmesi zorunludur.")
	@Column(name="lang_level")
	private char languageLevel;
	
	@Column(name="created_date")
	private Date createdDate;

}
