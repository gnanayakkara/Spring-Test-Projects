package com.gnanayakkara.SpringTest.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * 7 Oct 2022
 */

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserRequest {

	@NotNull(message = "Username should't be null")
	private String name;
	@Email
	private String email;
	@NotNull
	@Pattern(regexp = "^\\d{10}$",message = "invalid mobile number entered")
	private String mobile;
	private String gender;
	@Min(16)
	@Max(60)
	private int age;
	@NotBlank
	private String nationality;
}
