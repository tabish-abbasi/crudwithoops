package com.example.crud.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.example.crud.dao.UserDao;


public interface UserService {
	
	public void addUser(UserDao userDao);
	public UserDao getUser(int id);
	public void updateUser(UserDao userDao);
	public void deleteUser(int id);
	public Set<String> getUnique();
	public List<UserDao> getUsers();
	public void addAllUsers(List<UserDao> userDao);
	public Map<String, Integer> getByName();

}
