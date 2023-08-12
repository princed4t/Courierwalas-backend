package com.example.demo.service;

import java.util.List;

import com.example.demo.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponse {
	private String token;
	private String email;
	List<String> roles;
	
	
	

}
