package com.mrinal.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.mrinal.exception.UserNotFoundException;
import com.mrinal.model.ForgotPassword;
import com.mrinal.model.User;
import com.mrinal.model.UserDetails;
import com.mrinal.repo.UserDetailsRepo;
import com.mrinal.repo.UserRepo;
import com.mrinal.response.ForgotPasswordResponse;
import com.mrinal.response.GenericResponse;
import com.mrinal.response.UserResponse;

@Service
public class UserService {
	@Autowired
	UserRepo rp;
	@Autowired
	UserDetailsRepo udrp;
	
	

//    @Bean
//    public PasswordEncoder getPasswordEncoder(){
//        return new BCryptPasswordEncoder();
//    }

    public void save(User user){
        user.setPassword(user.getPassword());
        rp.save(user);
    }
	
	public ResponseEntity<GenericResponse> registerUser(User user){
		User newUser = new User();
        GenericResponse response =null;
        String userId="";
        try{
	          if (user != null) {
	        			 newUser.setFirstName(user.getFirstName());
	    	    	     newUser.setLastName(user.getLastName());
	    	    	     newUser.setEmailId(user.getEmailId());
	    	             newUser.setPassword(user.getPassword());
	    	             rp.save(newUser);
	    	             userId = String.valueOf(newUser.getId());
	    	             response= new UserResponse("SUCCESS","Successfully registered",newUser.getFirstName(),newUser.getLastName(),
	    	        		 newUser.getEmailId(),userId); 
	        	 }
	    
        }
        
        catch(DataIntegrityViolationException d){
      	  response = new GenericResponse("FAILURE","","Email Id already exist");
      	  return new ResponseEntity<GenericResponse>(response, HttpStatus.OK);
        }
        catch(Exception e){
      	  
        }

	   
	    return new ResponseEntity<GenericResponse>(response, HttpStatus.OK);
	}
	
	public ResponseEntity<ForgotPasswordResponse> resetPassword(ForgotPassword forgotPassword){
		ForgotPasswordResponse response = null;
		User u1 =new User();
		User user = new User();
		u1 = (User) rp.findByemailId(forgotPassword.getEmailId());
		if(forgotPassword.getOldPassword().equals(u1.getPassword())){
		if(forgotPassword.getNewPassword().equals(forgotPassword.getConfirmNewPassword())){
			user.setEmailId(u1.getEmailId());
			user.setFirstName(u1.getFirstName());
			user.setLastName(u1.getLastName());
			user.setPassword(forgotPassword.getNewPassword());
			user.setId(u1.getId());
			rp.save(user);
			response = new ForgotPasswordResponse("SUCCESS","Password changed Successfully","");
			return new ResponseEntity<ForgotPasswordResponse>(response, HttpStatus.CREATED);
		}else{
			response = new ForgotPasswordResponse("FAILURE","","New Password and Confirm Password didn't match");
			return new ResponseEntity<ForgotPasswordResponse>(response, HttpStatus.OK);
		}
		}else{
			response = new ForgotPasswordResponse("FAILURE", "", "You have entered wrong current password.");
			return new ResponseEntity<ForgotPasswordResponse>(response,HttpStatus.OK);
		}
	}
	public ResponseEntity<GenericResponse> loginUser(User user){
		User newUser = new User();
        UserResponse response =null;
        String userId="";
        try{
	          if (user.getEmailId() != null) {
	    	    newUser=(User)rp.findByemailId(user.getEmailId());
	    	    userId = String.valueOf(newUser.getId());
	             response= new UserResponse("SUCCESS","Successfully loggedIn",newUser.getFirstName(),newUser.getLastName(),
	        		 newUser.getEmailId(),newUser.getPassword(),userId);
	    }
        }catch(Exception e){
            	GenericResponse gr = new GenericResponse("FAILED","",e.getMessage(),HttpStatus.BAD_REQUEST);
            	return new ResponseEntity<GenericResponse>(gr, HttpStatus.BAD_REQUEST);
            }
	    return new ResponseEntity<GenericResponse>(response, HttpStatus.OK);
   
	}
	public ResponseEntity<GenericResponse> findUserByEmailId(String emailId){
		String userId = "";
	    User user=null;
	    try {
	       user = rp.findByemailId(emailId);
	       userId = String.valueOf(user.getId());
	      // user = (User) rp.findAll();
	    }
	    catch(Exception e ){
        	GenericResponse gr = new GenericResponse("FAILED","",e.getMessage(),HttpStatus.BAD_REQUEST);
        	return new ResponseEntity<GenericResponse>(gr, HttpStatus.BAD_REQUEST);
        }
	    UserResponse ur = new UserResponse("SUCCESS","user fetched successfully", user.getFirstName(), user.getLastName(), user.getEmailId(), user.getPassword(), userId);
	    return new ResponseEntity<GenericResponse>(ur, HttpStatus.FOUND);
	}

	public ResponseEntity<GenericResponse> addUserDetails(UserDetails userDetails) {
		try{
			udrp.save(userDetails);
			GenericResponse response =  new GenericResponse("SUCCESS", "User Details successfully added", "");
		    return new ResponseEntity<GenericResponse>(response,HttpStatus.OK);
			
			}catch(DataIntegrityViolationException d){
				GenericResponse response =  new GenericResponse("FAILED", "", "Details already exists for user id "+userDetails.getUser().getId());
			    return new ResponseEntity<GenericResponse>(response,HttpStatus.OK);
			}catch(Exception e ){
	        	GenericResponse gr = new GenericResponse("FAILED","",e.getMessage(),HttpStatus.BAD_REQUEST);
	        	return new ResponseEntity<GenericResponse>(gr, HttpStatus.BAD_REQUEST);
	        }
	}
	public ResponseEntity<GenericResponse> getUserDetailsById(int userId){
		User u = (User)rp.findByid(userId);
        try{  
        
        		System.out.println("Inside value range check");
               if(u == null){
            	   System.out.println("inside null user check");
        	       throw new UserNotFoundException("User with id "+userId+" not found",HttpStatus.NOT_FOUND);
                
        	}
        }catch(UserNotFoundException exp){
        	GenericResponse gr = new GenericResponse("FAILED","",exp.getErrorMsg(),exp.getStatusCode());
        	return new ResponseEntity<GenericResponse>(gr, HttpStatus.NOT_FOUND);
        }catch(MethodArgumentTypeMismatchException argExp){
        	GenericResponse gr = new GenericResponse("FAILED","",argExp.getMessage(),HttpStatus.BAD_REQUEST);
        	return new ResponseEntity<GenericResponse>(gr, HttpStatus.BAD_REQUEST);
        }catch(Exception e ){
        	GenericResponse gr = new GenericResponse("FAILED","",e.getMessage(),HttpStatus.BAD_REQUEST);
        	return new ResponseEntity<GenericResponse>(gr, HttpStatus.BAD_REQUEST);
        }
       
        	UserResponse ur = new UserResponse("SUCCESS", "User details fetched successfully", u.getFirstName(), u.getLastName(), u.getEmailId(), u.getPassword(),String.valueOf(u.getId()));
        	return new ResponseEntity<GenericResponse>(ur, HttpStatus.OK);
        
        	
            	
	}
	
}
