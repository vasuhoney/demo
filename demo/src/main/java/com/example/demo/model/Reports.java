package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "reports")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reports {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	private String nickName;
	
	private String address;
	
	private String dateOfBirth;
	
	private String city;

}
