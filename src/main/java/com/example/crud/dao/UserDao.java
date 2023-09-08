package com.example.crud.dao;

import java.util.Date;
import lombok.Data;

@Data
public class UserDao {
    
	private int id;
	
	private String name;
	
	private String mno;
	
	private Date createdAt;
	
	private Date updatedAt;
	
	
}
