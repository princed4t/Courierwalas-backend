package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Userdto {
	
	
	
	private String name;
	private String email;
	private String product;
	private  double productweight;
	private double productdistance;
	
	

}
