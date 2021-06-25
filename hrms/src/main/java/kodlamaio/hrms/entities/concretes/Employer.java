
  package kodlamaio.hrms.entities.concretes;
  
  
  import javax.persistence.Column; 
  import javax.persistence.Entity; 
  import javax.persistence.PrimaryKeyJoinColumn;
  import javax.persistence.Table;
  import javax.validation.constraints.NotBlank;
  import javax.validation.constraints.Size;

  import com.fasterxml.jackson.annotation.JsonIgnore;


  import lombok.AllArgsConstructor;
  import lombok.Data;
  import lombok.EqualsAndHashCode;
  import lombok.NoArgsConstructor;
 
  
  @Entity
  @Data
  @Table(name="employers")
  @NoArgsConstructor
  @AllArgsConstructor
  @EqualsAndHashCode(callSuper=false)
  @PrimaryKeyJoinColumn(name="user_id") 
  
  public class Employer extends User{
	
  
  @NotBlank(message="Şirket adı boş bırakılamaz.")
  @Column(name="company_name") 
  private String companyName;
  
  @NotBlank(message="Web adresi boş bırakılamaz.")
  @Column(name="web_address") 
  private String webAddress;
  
  @NotBlank(message="Telefon numarası boş bırakılamaz.")
  @Size(min=11,max=11,message="Telefon numarası 11 karakterden oluşmalıdır.")
  @Column(name="phone_number") 
  private String phoneNumber;
  
  @JsonIgnore
  @Column(name="user_confirm") 
  private boolean userConfirm; }
 