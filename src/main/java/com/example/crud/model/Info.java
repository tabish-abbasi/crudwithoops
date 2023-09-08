package com.example.crud.model;

import java.util.Date;

import javax.persistence.MappedSuperclass;

import lombok.Data;

@Data
@MappedSuperclass
public class Info {

	private Date createdAt;
	
	private Date updatedAt;
		
}
