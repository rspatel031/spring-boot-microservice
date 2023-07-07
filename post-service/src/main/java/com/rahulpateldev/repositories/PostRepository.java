package com.rahulpateldev.repositories;

import com.rahulpateldev.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, String> {
    List<Post> findPostsByUserId(String userId);
}
