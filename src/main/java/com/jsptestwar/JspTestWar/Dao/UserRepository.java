package com.jsptestwar.JspTestWar.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsptestwar.JspTestWar.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  
	User findByUsername(String username);
}
