package com.eduinx.songverse.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController {

	@GetMapping("/login")
	public String login()
	{
		return "login";

		
	}

	@GetMapping("/registration")
	public String registration() {
		return "registration";
	}

	@GetMapping("/newsong")
	public String newsong()
	{
		return "newsong";

	}

	@GetMapping("/about")
	public String aboutPage() {
		return "about"; // This will return the about.html template
	}
	

	@GetMapping("/contact")
	public String contactPage() {
	    return "contact"; // This will return the contact.html template
	}

    @GetMapping("/home")
    public String homePage() {
        return "home";
    }
   
    @GetMapping("navlogout")
	public String logout()
	{
		return "home";
	}




}









