package com.jsptestwar.JspTestWar.service;

public interface SecurityService {

	String findLoggedInUsername();

	void autologin(String username, String password);
}
