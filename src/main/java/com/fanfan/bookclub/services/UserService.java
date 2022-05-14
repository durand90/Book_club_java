package com.fanfan.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.fanfan.bookclub.models.LoginUser;
import com.fanfan.bookclub.models.UserModel;
import com.fanfan.bookclub.repositories.User;

@Service
public class UserService {
	
	@Autowired
	User userRepo;
	
	public List<UserModel> allUsers() {
        return userRepo.findAll();
    }
    // creates a book
    public UserModel createUser(UserModel b) {
        return userRepo.save(b);
    }
    // retrieves a book
    public UserModel findUser(Long id) {
        Optional<UserModel> optionalUserModel = userRepo.findById(id);
        if(optionalUserModel.isPresent()) {
            return optionalUserModel.get();
        } else {
            return null;
        }
    }
    public void deleteUserModel(Long id) {
		// TODO Auto-generated method stub
		userRepo.deleteById(id);
    }
		
		public UserModel updateUser(UserModel b) {
			return userRepo.save(b);
		}
		
		//--new to service--
		
		public UserModel register(UserModel newUser, BindingResult result) {
			//reject if the email is present in the database
			Optional <UserModel> potentialUser = userRepo.findByEmail(newUser.getEmail());
			if(potentialUser.isPresent()) {
				result.rejectValue("email", "registerErrors", "This Email already exist");
			}
			//reject if password and confirm password don't match
			if(!newUser.getPassword().equals(newUser.getConfirm())) {
				result.rejectValue("confirm", "registerErrors", "The confirm password must match password");
			}
			//return null if result has errors
			if (result.hasErrors()) {
				return null;
			}
			else {
				//Hash and set password, save user to the database
				String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
				newUser.setPassword(hashed);
				//save user to the database
				return userRepo.save(newUser);
			}
			
		}
		
		public UserModel login(LoginUser newLoginObject, BindingResult result) {
			
			//FIND THE USER IN THE DB
	    	Optional<UserModel> potentialUser = userRepo.findByEmail(newLoginObject.getEmail());
	    	if (!potentialUser.isPresent()) {
	    		result.rejectValue("email", "loginError", "email not found");
	    	} else {
	    		
	    		UserModel user = potentialUser.get();
//	    	Reject if BCrypt pass match fails
	    		if (!BCrypt.checkpw(newLoginObject.getPassword(), user.getPassword())) {
//	    		Reject
	    			result.rejectValue("password", "loginError", "invalid password");
	    		}
//	    	return null if result has errors
	    		if (result.hasErrors()) {
	    			return null;
	    		} else {
//	    		otherwise, return the user object
	    			return user;
	    		}
	    	}
	    	
	    	return null;
		}

}
