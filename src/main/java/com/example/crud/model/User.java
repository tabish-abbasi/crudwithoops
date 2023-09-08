package com.example.crud.model;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User extends Info {

	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	
	private String mno;
	
}
