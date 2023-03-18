package com.gnanayakkara.SpringTest.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * 7 Oct 2022
 */

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@ApiModel(description = "Details about the User Request")
public class UserRequest {

	@NotNull(message = "Username should't be null")
	@ApiModelProperty(notes = "The Name of User")
	private String name;
	@Email
	@ApiModelProperty(notes = "The person's emil address")
	private String email;
	@NotNull
	@Pattern(regexp = "^\\d{10}$",message = "invalid mobile number entered")
	@ApiModelProperty(notes = "The person's mobile number")
	private String mobile;
	private String gender;
	@Min(16)
	@Max(60)
	private int age;
	@NotBlank
	private String nationality;
}
