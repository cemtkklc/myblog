package com.jsptestwar.JspTestWar.service;

import com.jsptestwar.JspTestWar.model.User;

public interface UserService {

	void save(User user);

	User findByUsername(String username);
	
}
