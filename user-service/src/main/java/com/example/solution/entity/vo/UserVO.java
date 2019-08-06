package com.example.solution.entity.vo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class UserVO {
     
    private @NotNull @NotEmpty @Length(max=60) String firstName;
     
    private @NotNull @NotEmpty @Length(max=60) String lastName;
     
    private @NotNull @NotEmpty @Length(max=60) String email;
     
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}

	public UserVO(){
		
	}

	@Override
    public String toString() {
        return "UserVO [firstName=" + firstName +
                ", lastName=" + lastName + ", email=" + email   + "]";
    }
}
