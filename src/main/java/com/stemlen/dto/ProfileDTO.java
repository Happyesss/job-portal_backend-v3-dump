package com.stemlen.dto;

import java.util.Base64;
import java.util.List;

import org.springframework.data.annotation.Id;
import com.stemlen.entity.Profile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProfileDTO {
	@Id
	  private Long id;
	  private String name;
	  private String email;
	  private String jobTitle;
	  private String company;
	  private String location;
	  private String about;
	  private String picture;
	  private String profileBackground;
	  private Long totalExp;
	  private List<String>skills;
	  private List<Experience>experiences;
	  private List<Certification>certifications;
	  private List<Long>savedJobs;
	  
	  public Profile toEntity() {
	        return new Profile(this.id,this.name, this.email, this.jobTitle, this.company, this.location, this.about,
	        		           this.picture!=null?Base64.getDecoder().decode(this.picture):null,
	        		           this.profileBackground!=null?Base64.getDecoder().decode(this.profileBackground):null,
	                             this.totalExp ,this.skills, this.experiences, this.certifications,this.savedJobs); 
	    }
}
