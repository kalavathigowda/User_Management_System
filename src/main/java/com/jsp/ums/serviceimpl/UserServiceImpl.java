package com.jsp.ums.serviceimpl;
import org.hibernate.cache.spi.entry.StructuredCacheEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.ums.entity.User;
import com.jsp.ums.exception.UserNotFoundByIdException;
import com.jsp.ums.repository.UserRepo;
import com.jsp.ums.requestdto.UserRequest;
import com.jsp.ums.responsedto.UserResponse;
import com.jsp.ums.service.UserService;
import com.jsp.ums.util.ResponseStructure;

@Service
public class UserServiceImpl  implements UserService{
	@Autowired
	private UserRepo userRepo;

	@Autowired
	private ResponseStructure<UserResponse> structure;
	
	private User mapToUser(UserRequest request) {
		User user=new User();
		user.setUserName(request.getUserName());
		user.setUserEmail(request.getUserEmail());
		user.setUserPassword(request.getUserPassword());
		return user;
	}
	private UserResponse mapToUseResponse(User user) {
		UserResponse  response=new UserResponse();
		response.setUserId(user.getUserId());
		response.setUserName(user.getUserName());
		response.setUserEmail(user.getUserEmail());
		return response;
	}
	@Override
	public ResponseEntity<ResponseStructure<UserResponse>>  saveUser(UserRequest userRequest) {
	User user=userRepo.save(mapToUser(userRequest));
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setMessage("user saved successfully");
		structure.setData(mapToUseResponse(user));
		return new ResponseEntity<ResponseStructure<UserResponse>>(structure,HttpStatus.CREATED)  ;
	}
	@Override
	public ResponseEntity<ResponseStructure<UserResponse>> updateUser(int userId, User user) {
		User user2=userRepo.findById(userId).map(u->{
			user.setUserId(userId);
			return userRepo.save(user);
		})
		.orElseThrow(()->new RuntimeException());	
		
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("user updated seccessfully");
		structure.setData(mapToUseResponse(user2));
		
		return new  ResponseEntity<ResponseStructure<UserResponse>>(structure,HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<ResponseStructure<UserResponse>> deleteUser(int userId, User user) {
		User user2=userRepo.findById(userId).map(u->{
			user.setUserId(userId);
			return userRepo.save(user);
		})
		.orElseThrow(()->new RuntimeException());	
		
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("user delete seccessfully");
		structure.setData(mapToUseResponse(user2));
		
		return new  ResponseEntity<ResponseStructure<UserResponse>>(structure,HttpStatus.OK);
	}
	@Override
	public ResponseEntity<ResponseStructure<UserResponse>> findUserByid(int userId) {
		User user=userRepo.findById(userId).orElseThrow(()->new UserNotFoundByIdException("failed to find user"));
		
		structure.setStatus(HttpStatus.FOUND.value());
		structure.setMessage("user found successfully.");
		structure.setData(mapToUseResponse(user));
		return new  ResponseEntity<ResponseStructure<UserResponse>>(structure,HttpStatus.FOUND);
	}
	
	
}
	

