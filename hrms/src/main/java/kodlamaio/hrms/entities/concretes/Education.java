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
@AllArgsConstructor
@NoArgsConstructor
@Table(name="resume_edu")
public class Education {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne(targetEntity = Resume.class)
	@JoinColumn(name="resume_id")
	private Resume resume;
	
	@NotBlank(message="Okul ismi girilmelidir.")
	@Column(name="school_name")
	private String schoolName;
	
	@ManyToOne(targetEntity = Graduate.class)
	@JoinColumn(name="graduate_id", referencedColumnName = "id", nullable = false)
	private Graduate graduate;
	
	@NotBlank(message="Okunan bölüm girilmelidir.")
	@Column(name="school_department")
	private String schoolDepartment;
	
	@Column(name="started_date")
	private Date startedDate;
	
	@Column(name="ended_date")
	private Date endedDate;
	
	@Column(name="created_date")
	private Date createdDate;
	
}
