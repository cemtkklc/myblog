package com.jsptestwar.JspTestWar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jsptestwar.JspTestWar.service.PostService;

@Controller
public class HomeController {

	@Autowired
	private PostService postService;
	
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("postList" , postService.listLast5());
		
		return "index";
		
	}
}
