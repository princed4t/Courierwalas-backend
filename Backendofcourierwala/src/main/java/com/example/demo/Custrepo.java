package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface Custrepo extends PagingAndSortingRepository<Customer,Integer>,JpaRepository<Customer, Integer>{
          Customer findByEmail(String email);
}
