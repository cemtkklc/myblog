package com.jsptestwar.JspTestWar.controller;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jsptestwar.JspTestWar.model.User;

import com.jsptestwar.JspTestWar.service.SecurityService;
import com.jsptestwar.JspTestWar.service.UserService;
import com.jsptestwar.JspTestWar.validator.UserValidator;

@Controller
//@RequestMapping("/users")
public class LoginController {

	@Autowired
	private UserService userService;
	@Autowired
	private SecurityService securityService;
	@Autowired
	@Qualifier("userValidator")
	private UserValidator userValidator;
	//@Autowired
	//private NotificationService notificationService;
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(userValidator);
	}
	
	@RequestMapping("/login")
	public String login() {
		
		return "login";
	}
	
	@PostMapping("/authUser")
	public String authUser() {
		return "redirect:/";
	}
	
	@GetMapping("/register")
	public String registerPage(Model model) {
		model.addAttribute("userForm" , new User());
		return "register";
	}
	@PostMapping("/registerAuth")
	public String registerProcess(@ModelAttribute("userForm")@Validated User userForm, BindingResult bindingResult) {
		userValidator.validate(userForm, bindingResult);
		if(bindingResult.hasErrors()) {
			//notificationService.addErrorMessage("Fill form correct!");
			return "redirect:/register";
		}
		String originalPassword= userForm.getPassword();
		userService.save(userForm);
		securityService.autologin(userForm.getUsername(),originalPassword);
		
		return "redirect:/";
	}
	
	
	
	
	
	
}
