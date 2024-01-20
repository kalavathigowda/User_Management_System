package com.jsp.ums.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.ums.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

}
