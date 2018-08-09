package com.jsptestwar.JspTestWar.service;

import java.util.List;
import java.util.Optional;

import com.jsptestwar.JspTestWar.model.Post;

public interface PostService {

	List<Post> listAll();
	List<Post> listLast5();
	Optional<Post> findById(Long id);
	Post create(Post post);
	Post update(Post post);
	void deleteById(Long id);
}
