package com.reservo.dto;

import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SignInRequestDto {
	
	@Email(message = "Invalid email format")
	private String email;

	@Length(min = 3,max=20,message = "Invalid password length")
	private String password;
}
