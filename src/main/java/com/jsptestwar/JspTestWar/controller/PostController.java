package com.jsptestwar.JspTestWar.controller;


import java.security.Principal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jsptestwar.JspTestWar.model.Post;

import com.jsptestwar.JspTestWar.service.NotificationService;
import com.jsptestwar.JspTestWar.service.PostService;
import com.jsptestwar.JspTestWar.service.UserService;

@Controller
@RequestMapping("/post")
public class PostController {

	@Autowired
	private PostService postService;
	@Autowired
	private UserService userService;
	
	@Autowired
	private NotificationService notificationService;
	
	@RequestMapping("/all")
	public String listAll(Model model) {
		model.addAttribute("allPost",postService.listAll());
		
		return "post";
	}
	
	
	@GetMapping("/{id}")
	public String listByid(@PathVariable("id") Long id, Model model) {
		Post post =  postService.findById(id).orElse(null);
		if(post == null) {
			notificationService.addErrorMessage(" Post Not Found");
			return "redirect:/";
		}
		model.addAttribute("post",post);
		
		return "singlepost";
		
	}			
	@GetMapping("/create")
	public String createForm(Model model) {
		Post tempPost = new Post();
		model.addAttribute("tempPost", tempPost);
		return "postCreate";
	}
	
	@PostMapping("/createPost")
	public String creatingPost(@ModelAttribute("tempPost") Post post,Principal principal) {
		Date date = new Date();
		post.setDate(date);
		post.setAuthor(this.userService.findByUsername(principal.getName()));
		
		postService.create(post);
		return "redirect:/";
	}
	
	
}
