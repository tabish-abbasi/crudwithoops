package com.example.crud.controller;


import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.dao.UserDao;
import com.example.crud.service.UserServiceImp;


@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserServiceImp userService;


	@PostMapping("/add")
	private ResponseEntity<?> addUser(@RequestBody UserDao userDao){
		
		userService.addUser(userDao);	 
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("User Added!");
	}

	@GetMapping("/get/{id}")
	private ResponseEntity<?> getUser(@PathVariable int id){

		UserDao userDao=userService.getUser(id);
		return ResponseEntity.status(HttpStatus.FOUND).body(userDao);
	}


	@PutMapping("/update")
	private ResponseEntity<String> updateUser(@RequestBody UserDao userDao){

		userService.updateUser(userDao);
		return ResponseEntity.status(HttpStatus.CREATED).body("User Updated!");
	}

	@DeleteMapping("/delete/{id}")
	private ResponseEntity<String> deleteUser(@PathVariable int id){
	
		userService.deleteUser(id);
		return ResponseEntity.status(HttpStatus.FOUND).body("User Deleted!");
	}

	@GetMapping("/getAll")
	private ResponseEntity<List<UserDao>> getAll(){
	
		List<UserDao> dao = userService.getUsers();
		return ResponseEntity.status(HttpStatus.OK).body(dao);
	}

	@GetMapping("/getUnique")
	private ResponseEntity<Set<String>> unique(){

		Set <String> set=userService.getUnique();
		return ResponseEntity.status(HttpStatus.OK).body(set);
	}


	@PostMapping("/addAll")
	private ResponseEntity<String> addAll(@RequestBody List<UserDao> dao){

		userService.addAllUsers(dao);
		return ResponseEntity.status(HttpStatus.OK).body("All the users are added!");
	}

	@GetMapping("/getNameOccurrences")
	private ResponseEntity<Map<String, Integer>> getName(){

		 Map<String, Integer> map=userService.getByName();
		return ResponseEntity.status(HttpStatus.FOUND).body(map);
	}
}
