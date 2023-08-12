package com.example.demo;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Consigment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productid;
	private String product;
	private LocalDateTime localDateTime;
	private String address1;
	private String address2;
	private int pincode;
	private String deliverydate;
	@ManyToOne
    @JoinColumn(name="fk",referencedColumnName = "id")
    @JsonBackReference
	private Customer customer;
	
	
	
	

}
