package com.luv2code.springboot.medylite.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.medylite.entity.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {

}
