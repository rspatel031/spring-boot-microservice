package com.rahulpateldev.services;

import com.rahulpateldev.entities.Post;
import com.rahulpateldev.exceptions.custom.ResourceNotFoundException;
import com.rahulpateldev.repositories.PostRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post savePosts(Post post) {
        post.setId(UUID.randomUUID().toString());
        return this.postRepository.save(post);
    }

    public Post getPosts(String id) {
        return this.postRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found on server!!"));
    }

    public List<Post> getAllPosts() {
        return this.postRepository.findAll();
    }

    public List<Post> getAllPostsByUserId(String id) {
        return this.postRepository.findPostsByUserId(id);
    }

    public Post updatePosts(Post post, String id) {
        Post dbPost = this.getPosts(id);
        dbPost.setName(post.getName());
        dbPost.setDescription(post.getDescription());
        return this.postRepository.save(dbPost);
    }

    public void deletePosts(String id) {
        this.getPosts(id);
        this.postRepository.deleteById(id);
    }
}
