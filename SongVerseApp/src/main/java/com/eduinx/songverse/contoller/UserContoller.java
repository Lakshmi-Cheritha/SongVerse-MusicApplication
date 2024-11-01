package com.eduinx.songverse.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eduinx.songverse.entity.Song;
import com.eduinx.songverse.entity.User;
import com.eduinx.songverse.service.SongService;
import com.eduinx.songverse.serviceimpl.UserServiceImpl;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserContoller
{
	
	//	//User details will be added 
	//	//to the DB from the registration form
	//	@PostMapping("/register")
	//	public String addUser(@ModelAttribute User user)
	//	{
	//		
	//		userImpl.addUser(user);
	//		return "home";
	//	}
	@Autowired
	UserServiceImpl userImpl;
	@Autowired
	SongService songService;
	//User details will be added 
	//to the DB from the registration form
	@PostMapping("/register")
	public String addUser(@ModelAttribute User user)
	{
		//Email taken from registration form
		String email = user.getEmail();
		//Checking if the email as entered in registration 
		//form is present in DB or not  
		boolean status=userImpl.emailExists(email);
		if(status== false)
		{
			userImpl.addUser(user);
			System.out.println("User Added");
		}else {
			System.out.println("User Already Exists");
		}
		return "home";
	}
	//according  to  the entered login credentials will navigate
	//to adminHome page or UserHome page
	//Fetch email from DB , Check the role , according to the role 
	//it will redirected to the appropriate page
	@PostMapping("/validate")
	public String validate(@RequestParam("email") String email,
			@RequestParam ("password")String password,HttpSession session,Model model)
	{
		if(userImpl.validateUser(email,password)==true)
		{
			String role=userImpl.getRole(email);
			session.setAttribute("email", email);
			if(role.equals("admin"))
			{
				return "adminhome";
			}
			else
			{	
				User user = userImpl.getUser(email);
			boolean	userstatus = user.isIspremium();
			// logic
			List<Song> fetchAllSongs = songService.fetchAllSongs();
			model.addAttribute("songs", fetchAllSongs);
			model.addAttribute("ispremium", userstatus);
				return "userhome";
			}
		}else {
			return "login";
		}
	}
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session)
	{
		session.invalidate();
		return "index";
	}
}
















