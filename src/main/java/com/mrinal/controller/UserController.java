package com.mrinal.controller;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.transaction.Transactional;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mrinal.exception.UserNotFoundException;
import com.mrinal.model.ForgotPassword;
import com.mrinal.model.User;
import com.mrinal.model.UserDetails;
import com.mrinal.repo.UserDetailsRepo;
import com.mrinal.repo.UserRepo;
import com.mrinal.response.ForgotPasswordResponse;
import com.mrinal.response.GenericResponse;
import com.mrinal.response.UserResponse;
import com.mrinal.service.UserService;

import ch.qos.logback.classic.Logger;


@RestController
@RequestMapping("/users")
public class UserController {
    
	@Autowired
	UserService us;
	
	@Autowired
	UserRepo rp;
	
	@Autowired
	UserDetailsRepo udr;
	

	/*Get All Users List from Database*/
	@CrossOrigin(origins = "http://localhost:8100", maxAge = 7200)
	@RequestMapping(method=RequestMethod.GET,value="/getAllUsers")
	@ResponseBody
	public ArrayList<User> getAllUser(){
		ArrayList<User> users = new ArrayList<User>();
		users = rp.findAll();
		return users;
		
	}
	
	@CrossOrigin(origins = "http://localhost:8100", maxAge = 7200)
	@RequestMapping("/getUsers")
	@ResponseBody
	public List<User> getUser(){
		System.out.println("inside getUser");
		List<User> u = rp.findUsers();
		return u;
	}
	@CrossOrigin(origins = "http://localhost:8100", maxAge = 7200)
	@RequestMapping(value="/getUser/{userId}")
	public ResponseEntity<GenericResponse> getUserById(@PathVariable("userId") int userId){
		
		return us.getUserDetailsById(userId);
		
	}
	
    
	  @CrossOrigin(origins = "http://localhost:8100", maxAge = 7200)
	  @RequestMapping("/getUserByEmail")
	  @ResponseBody
	  public ResponseEntity<GenericResponse> getByFirstName(String emailId) {
	    return us.findUserByEmailId(emailId);
	  }  
	  
	@CrossOrigin(origins = "http://localhost:8100", maxAge = 7200)
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<GenericResponse> login(@RequestBody User user) {
          return us.loginUser(user);
	}
	
	@CrossOrigin(origins = "http://localhost:8100", maxAge = 7200)
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<GenericResponse> register(@RequestBody User user) {
		
		return us.registerUser(user);
	}
	
	@CrossOrigin(origins = "http://localhost:8100", maxAge = 7200)
	@RequestMapping(value="/forgotPassword",method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<ForgotPasswordResponse> forgotPassword(@RequestBody ForgotPassword forgotPassword ){
	    return us.resetPassword(forgotPassword);	
	}
//	user update request
	@CrossOrigin(origins = "http://localhost:8100", maxAge = 7200)
	@RequestMapping(value="/addUserDetails",method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<GenericResponse> addUserDetails(@RequestBody UserDetails userDetails){
		return us.addUserDetails(userDetails);
		
	}
	
	
	
}
