
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
  @Table(name="employees")
  @NoArgsConstructor
  @AllArgsConstructor
  @PrimaryKeyJoinColumn(name="user_id") 
  @EqualsAndHashCode(callSuper=false)
  public class Employee extends User{
  

  @NotBlank(message="isim boş bırakılamaz.")
  @Size(min=2,message="isim en az 2 karakterden oluşmalıdır.")
  @Column(name="name") 
  private String name;
  
  @NotBlank(message="Soyisim boş bırakılamaz.")
  @Size(min=2,message="Soyisim en az 2 karakterden oluşmalıdır.")
  @Column(name="surname") 
  private String surname;
  
  @JsonIgnore
  @Column(name="verify")
  private boolean verify;
  }
 