package com.example.demo.dto;

import java.util.List;

import com.example.demo.Consigment;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customerdto {
	private int id;
	private String name;
	private String email;
	private  String password;
	private  String product;
	private  String productweight;
	private   String productdistance;
	
	
	@Lob
	@Column(name="image",columnDefinition = ("BLOB"))
    private byte[] image;
    
	

}
