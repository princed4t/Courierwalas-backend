package com.example.demo.service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Customer;
import com.example.demo.Custrepo;
import com.example.demo.Consigment;
import com.example.demo.Consigmentrepo;
import com.example.demo.dto.Customerdto;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class Servicess {
	
	@Autowired
	Custrepo custrepo;
	@Autowired
	PasswordEncoder passwordencoder;
	@Autowired
	Consigmentrepo consigmentrepo;
	
	@Autowired
	Utilityclass utilityclass;
	
	public String registercustomer(String name,String email,String password,String product,double proweight,double prodistance, MultipartFile images) throws IOException {
		     byte[] bytes = images.getBytes();
		  byte[] compressImage = utilityclass.compressImage(images);
		
		
	   Customer customer=new Customer();
	    customer.setImage(compressImage);
	   
	   customer.setName(name);
	   customer.setEmail(email);
	   customer.setPassword(passwordencoder.encode(password));
	   customer.setRoles("ROLE_USER");
	   customer.setProduct(product);
	   customer.setProweight(proweight);
	   customer.setProdistance(prodistance);
	   customer.setImage(compressImage);
		
	customer.setPassword(passwordencoder.encode(password));
		custrepo.save(customer);
		return "scuccesfulladded";
		
		
	}
	
	  public void workaddedsuccesssfully(String email,Consigment consigment) {
	 Customer cust = custrepo.findByEmail(email); // System.out.println(cust);
  consigment.setCustomer(cust); 
  consigment.setProduct(cust.getProduct());
  
  
  LocalDateTime lcd=LocalDateTime.now();
	 consigment.setLocalDateTime(lcd); List<Consigment>li=new ArrayList<>();
	  li.add(consigment); cust.setListofconsigment(li);
	 consigmentrepo.save(consigment); custrepo.save(cust);
	  
	
	 
	 
	 
	  }
	

}
