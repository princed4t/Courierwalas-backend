package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Consigmentrepo extends JpaRepository<Consigment,Integer>{
  
	
	
	List<Consigment> findAllByCustomer(Customer customer);
	
	
	
	
	
	
	
}
