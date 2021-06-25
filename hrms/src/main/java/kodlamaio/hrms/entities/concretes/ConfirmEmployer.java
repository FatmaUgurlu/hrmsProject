package kodlamaio.hrms.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Table(name="confirm_employers")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ConfirmEmployer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@OneToOne(targetEntity = Employer.class)
	@JoinColumn(name="employer_id", referencedColumnName="user_id")
	private Employer employer;
	
	@Column(name="confirmed_employee")
	private int comfirmedEmployee;
	
	@Column(name="confirmed_date")
	private Date comfirmedDate;
	
	@Column(name="is_confirmed")
	private boolean isConfirmed;
	

	
}
