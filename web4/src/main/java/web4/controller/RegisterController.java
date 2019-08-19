package web4.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import web4.model.User;


@Controller
public class RegisterController {
		
		
	@ModelAttribute("user")
	public User construct() {
		return new User();
	}
	
	@GetMapping("/register")
	   public String loginGet() {
	      return "register";
	   }
	
	
	@PostMapping("/register")
		public String loginPost(@ModelAttribute("user") User user) {
		System.out.println(user.getName()+" "+user.getPassword()+" "+user.getRole());
		return "auth";
	}
	
}
