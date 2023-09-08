package com.example.crud.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.crud.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

}
