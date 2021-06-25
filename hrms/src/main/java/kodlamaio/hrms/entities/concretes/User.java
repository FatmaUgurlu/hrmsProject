package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;

@Data
@Entity
@Table(name="users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Email(message = "Geçerli bir email adresi giriniz.")
	@NotBlank(message="Email alanı boş bırakılmaz.")
	@Column(name="mail")
	private String mail;
	
	@NotBlank(message="Şifre alanı boş bırakılmaz.")
	@Size(min=6, max=16, message="En az 6, en fazla 16 karakterden oluşmalıdır.")
	@Column(name="password")
	private String password;
	
	@NotBlank(message="Şifre boş bırakılamaz.")
	@Transient
	@JsonProperty(access = Access.WRITE_ONLY)
	private String passwordRepeat;
	
	@JsonIgnore
	@Column(name="verify")
	private boolean verify = false;
}
