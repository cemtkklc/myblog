package com.jsptestwar.JspTestWar.service;

import java.util.HashSet;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jsptestwar.JspTestWar.Dao.RoleRepository;
import com.jsptestwar.JspTestWar.Dao.UserRepository;
import com.jsptestwar.JspTestWar.model.Role;
import com.jsptestwar.JspTestWar.model.User;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	@Override
	public void save(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		
		/*Role role = new Role();
		role.setName("default");
		roleRepository.save(role);
		*/
		Role role = roleRepository.findById(1L).orElse(null);
		
		Set<Role> roleList = new HashSet<>();
		roleList.add(role);
		user.setRoles(roleList);
		userRepository.save(user);

	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(username);
	}

}
