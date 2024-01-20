package com.jsp.ums.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.ums.entity.User;
import com.jsp.ums.requestdto.UserRequest;
import com.jsp.ums.responsedto.UserResponse;
import com.jsp.ums.util.ResponseStructure;


public interface UserService {

//	public ResponseEntity<ResponseStructure<UserResponse>> saveUser(User user);

	public ResponseEntity<ResponseStructure<UserResponse>> updateUser(int userId, User user);

public  ResponseEntity<ResponseStructure<UserResponse>> saveUser(UserRequest userRequest);


 public ResponseEntity<ResponseStructure<UserResponse>> deleteUser(int userId, User user);


public ResponseEntity<ResponseStructure<UserResponse>> findUserByid(int userId);

	
}
