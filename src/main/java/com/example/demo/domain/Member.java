package com.example.demo.domain;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {
	
	private Long id;
	
	
	@NotBlank
	private String name;
	
	@Min(value=10)
	@Max(value=100000)
	private float price;

}
