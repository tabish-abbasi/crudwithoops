package com.example.crud.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.dao.UserDao;
import com.example.crud.model.User;
import com.example.crud.repo.UserRepo;



@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepo userRepo;

	/**
	 * ADD USER 
	 */
	@Override	
	public void addUser(UserDao userDao) {

		User user =this.convertDaoToEntity(userDao);
		user.setCreatedAt(new Date());
		userRepo.save(user); 
	}

	/**
	 *  GET USER 
	 */
	@Override
	public UserDao getUser(int id) {

		User user=userRepo.findById(id).orElse(null); 
		UserDao userDao=this.convertEntityToDao(user);
		return userDao;
	}
	
	/**
	 * Converting DaoToEntity to ADD USER
	 * @param userDao
	 * @return
	 */
	private User convertDaoToEntity(UserDao userDao) { 
		User user= new User();
		BeanUtils.copyProperties(userDao,user); 
		return user; 
	}

	/**
	 * Converting EntityToDao to GET USER
	 * @param user
	 * @return
	 */
	private UserDao convertEntityToDao(User user) { 

		UserDao userDao=new UserDao();
		BeanUtils.copyProperties(user, userDao);
		return userDao;  
	}

	/**
	 * UPDATE USER
	 */
	@Override
	public void updateUser(UserDao userDao) {

		User user =this.convertDaoToEntity(userDao);
		user.setUpdatedAt(new Date());
		userRepo.save(user);
	}
	
	/**
	 * DELETE USER
	 */
	@Override
	public void deleteUser(int id) {

		User user =this.userRepo.findById(id).orElse(null);
		userRepo.delete(user);
	}

	/**
	 * To GET UNIQUE USER
	 */
	@Override
	public Set<String> getUnique() {

		List<User> users= userRepo.findAll();
		Set<String> set = new HashSet<String>();	
		for(User user:users) {
			set.add(user.getName());
		}

		return set;
	}
	
	/**
	 * GET ALL USERS
	 */
	@Override
	public List<UserDao> getUsers() {

		List<User> users=userRepo.findAll();
		List<UserDao> userDaos = new ArrayList<UserDao>();
		for(User user:users) {
			userDaos.add(this.convertEntityToDao(user));
		}
		return userDaos;
	}


	/**
	 * ADD ALL USERS
	 */
	@Override
	public void addAllUsers(List <UserDao> userDaos) {
		
		List<User> users = new ArrayList<User>();
		for(UserDao userDao:userDaos) {
			users.add(this.convertDaoToEntity(userDao));
		}
		userRepo.saveAll(users);
	}

	/**
	 * To Count The Occurrence	
	 */
	@Override
	public  Map<String, Integer> getByName() {

		List<User> users=userRepo.findAll();
		Map<String,Integer> map=new HashMap<>();
		for (User m:users) {
			if(map.containsKey(m.getName())) {
				int count = map.get(m.getName()) +1 ;
				map.put(m.getName(), count);
			}else {
				map.put(m.getName(), 1);
			}			
		}
		return map;	
	}

}
