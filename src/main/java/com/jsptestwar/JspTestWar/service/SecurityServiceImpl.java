package com.jsptestwar.JspTestWar.service;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceImpl implements SecurityService {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private NotificationService notifyService;
	
	private static final Logger logger = LoggerFactory.getLogger(SecurityServiceImpl.class);
	
	
	@Override
	public String findLoggedInUsername() {
			Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
			if(userDetails instanceof UserDetails) {
				return ((UserDetails) userDetails).getUsername();
			}
		
		
		
		return null;
	}

	@Override
	public void autologin(String username, String password) {
			UserDetails userDetails = userDetailsService.loadUserByUsername(username);
			notifyService.addInfoMessage("User name: "+ username + "password: " + password + " Authorities: " +  userDetails.getAuthorities() );

			//Set<GrantedAuthority> listOfAuth = new HashSet<>();
			
			//listOfAuth.add(new SimpleGrantedAuthority("ROLE_default"));
			
			UsernamePasswordAuthenticationToken userNamePasswordAuthToken = 
					new UsernamePasswordAuthenticationToken(userDetails, password,userDetails.getAuthorities());
			
			Authentication auth = authenticationManager.authenticate(userNamePasswordAuthToken);
			if(auth.isAuthenticated()) {
				SecurityContextHolder.getContext().setAuthentication(auth);
				logger.debug(String.format("Auto Login  %s Succesfull!", username));
				notifyService.addInfoMessage("Auto Login is Successfull!");
			}else {
				notifyService.addInfoMessage("Auto login failed!");
				logger.debug(String.format("Auto Login  %s Failed", username));
			}
		
		
	}

}
