package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "demo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Demo {
	
	@Id
	@GeneratedValue
	private Long id;
	private String recipient;
    private String message;
    private String subject;
    private String attachment;

}
