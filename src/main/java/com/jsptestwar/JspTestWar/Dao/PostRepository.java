package com.jsptestwar.JspTestWar.Dao;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import com.jsptestwar.JspTestWar.model.Post;
@Repository
public interface PostRepository extends JpaRepository<Post, Long>{

@Query("SELECT p FROM Post p LEFT JOIN FETCH p.author ORDER BY p.date DESC")
List<Post> findAll();





}
