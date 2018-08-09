package com.jsptestwar.JspTestWar.service;



import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.jsptestwar.JspTestWar.Dao.PostRepository;
import com.jsptestwar.JspTestWar.model.Post;
@Service
@Primary
public class PostJpaImpl implements PostService {

	@Autowired
	private PostRepository postRepo;
	
	@Override
	public List<Post> listAll() {
		// TODO Auto-generated method stub
		return this.postRepo.findAll();
	}

	@Override
	public List<Post> listLast5() {
		// TODO Auto-generated method stub
		return this.postRepo.findAll().stream()
				.sorted((a,b) -> b.getDate().compareTo(a.getDate()))
				.limit(5)
				.collect(Collectors.toList());
	}

	@Override
	public Optional<Post> findById(Long id) {
		// TODO Auto-generated method stub
		return this.postRepo.findById(id);
	}

	@Override
	public Post create(Post post) {
		// TODO Auto-generated method stub
		return this.postRepo.save(post);
	}

	@Override
	public Post update(Post post) {
		Post tempPost = this.postRepo.findById(post.getId()).orElse(null);
		tempPost.setTitle(post.getTitle());
		tempPost.setBody(post.getBody());
		tempPost.setDate(post.getDate());
		tempPost.setAuthor(post.getAuthor());
		return tempPost;
	}

	@Override
	public void deleteById(Long id) {

		this.postRepo.deleteById(id);
	}

}
