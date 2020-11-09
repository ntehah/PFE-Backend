package com.memoire.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.memoire.entity.User;

public interface UserRepository  extends JpaRepository<User, Long>{
public  User findByUsername(String username);
public  User findById(long id );

}
