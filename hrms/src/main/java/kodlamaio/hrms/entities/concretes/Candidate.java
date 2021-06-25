
  package kodlamaio.hrms.entities.concretes;
  
  
  
  import javax.persistence.Column; 
  import javax.persistence.Entity;
  
  import javax.persistence.Table;
  import javax.validation.constraints.NotBlank;
  import javax.validation.constraints.Size;

  import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


  import lombok.AllArgsConstructor;
  import lombok.Data;
  import lombok.EqualsAndHashCode;
  import lombok.NoArgsConstructor;
  
  @Entity
  @Data
  @Table(name="candidates")  
  @NoArgsConstructor  
  @AllArgsConstructor
  @EqualsAndHashCode(callSuper=false)
  @JsonIgnoreProperties({"hibernateLazyIntializer", "handler"})
  public class Candidate extends User{
  
  
  @NotBlank(message="İsim boş geçilemez.")
  @Size(min=2, message="isim en az 2 karakterden oluşmalıdır.")
  @Column(name="name") 
  private String name;
  
  @NotBlank(message="Soyisim boş geçilemez.")
  @Size(min=2, message="Soyisim en az 2 karakterden oluşmalıdır.")
  @Column(name="surname") 
  private String surname;
  
  @NotBlank(message="TC kimlik numarası boş bırakılamaz.")
  @Size(min=11, max=11, message="TC kimlik no 11 karakterden oluşmalıdır.")
  @Column(name="national_identity") 
  private String nationalIdentity;
  
  @NotBlank(message="Doğum yılı boş bırakılamaz.")
  @Column(name="birth_year") 
  private String birthYear;
  
  }
 