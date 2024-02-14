package com.reservo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SignUpRequest {
	@JsonProperty(access = Access.READ_ONLY) // this property only used during ser.
	private Long id;
	
	@NotBlank(message = "First Name required")
	private String firstName;
	
	private String lastName;
	
	@Email(message = "Invalid Email!!!")
	private String email;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	private String confirmPassword;
	
	private String mobileNo;
	
	private String address;
	
	public SignUpRequest(String firstName, String lastName,
			String email, String password,String userName, String mobileNo, String address, String confirmPassword) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.mobileNo = mobileNo;
		this.address = address;
	}
}
