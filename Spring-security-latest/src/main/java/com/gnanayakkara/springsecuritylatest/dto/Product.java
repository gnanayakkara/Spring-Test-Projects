package com.gnanayakkara.springsecuritylatest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/*
 * 26 Mar 2023
 */
@Data
@AllArgsConstructor
@Builder
public class Product {

	private Integer productId;
	private String name;
	private Integer qty;
	private Double price;
}
