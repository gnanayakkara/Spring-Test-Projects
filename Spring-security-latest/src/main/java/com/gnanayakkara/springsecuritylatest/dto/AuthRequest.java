package com.gnanayakkara.springsecuritylatest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * 31 Mar 2023
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {

	private String userName;
	private String password;
}
