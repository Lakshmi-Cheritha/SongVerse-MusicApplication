package com.eduinx.songverse.serviceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduinx.songverse.entity.User;
import com.eduinx.songverse.repository.UserRepository;
import com.eduinx.songverse.service.UserService;
@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	UserRepository userRepo;
	//User Added to DB
	public String addUser(User user) 
	{
		userRepo.save(user);
		return "User added successfully";	
	}


	//Will check for duplicate entries Using Email
	public boolean emailExists(String email) 
	{
		if(userRepo.findByEmail(email)!=null)
		{
			return true;
		}
		else {
			return false;
		}
	}

	//Validate the enter credentials from login page 
	//Here this  will Check whether the entered credentials are matching
	//with the credentials present in the DB if matching 
	//<valid user,navigate to login page> IF Not <Navigate to >
	public boolean validateUser(String email, String password)
	{
		User user = userRepo.findByEmail(email);
		String dbpwd = user.getPassword();
		if( password.equals(dbpwd))
		{
			return true;
		}else {



			return false;

		}}


	public String getRole(String email) 
	{
		User user = userRepo.findByEmail(email);

		return user.getRole();
	}


	@Override
	public User getUser(String email) {

		return userRepo.findByEmail(email);
	}


	@Override
	public void updateUser(User user) {

		userRepo.save(user);

	}

}
