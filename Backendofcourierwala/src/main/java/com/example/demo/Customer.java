package com.example.demo;



import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Setter
@Getter
@NoArgsConstructor

public class Customer implements UserDetails{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	 
	private String name;
	
	private String email;
	 @JsonIgnore
    private String password;
    
    private String roles;
    
    private String product;
    
    private double proweight;
    private double prodistance;
    
    
     
  
    @OneToMany(mappedBy = "customer",fetch=FetchType.LAZY,cascade = CascadeType.ALL)
    
    @JsonManagedReference
    private List<Consigment> listofconsigment; 
    
	@Lob
	@Column(name="image",columnDefinition = ("BLOB"))
	@JsonIgnore
    private byte[] image;
    
	@Override
	@JsonIgnore
	public Collection<? extends GrantedAuthority> getAuthorities() {
		 
			List<SimpleGrantedAuthority> list=new ArrayList<>();
	      list.add(new SimpleGrantedAuthority(this.roles));
		return list;
	}

	@Override
	@JsonIgnore
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.email;
	}

	@Override
	@JsonIgnore
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	@JsonIgnore
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	@JsonIgnore
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	@JsonIgnore
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public Customer(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}
    
    
	

	



	
	

}
