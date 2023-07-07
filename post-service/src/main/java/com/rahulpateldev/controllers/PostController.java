package com.rahulpateldev.controllers;

import com.rahulpateldev.entities.Post;
import com.rahulpateldev.services.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    //    addPosts
    @PostMapping
    public ResponseEntity<Post> addPosts(@RequestBody Post post) {
        Post savedPosts = this.postService.savePosts(post);
        return new ResponseEntity<>(savedPosts, HttpStatus.CREATED);
    }

    //    getPosts
    @GetMapping("/{id}")
    public ResponseEntity<Post> getPosts(@PathVariable String id) {
        Post posts = this.postService.getPosts(id);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    //    getAllPosts
    @GetMapping("/users/{id}")
    public ResponseEntity<List<Post>> getAllPostsByUserId(@PathVariable String id) {
        List<Post> allPosts = this.postService.getAllPostsByUserId(id);
        return new ResponseEntity<>(allPosts, HttpStatus.OK);
    }

    //    getAllPosts
    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        List<Post> allPosts = this.postService.getAllPosts();
        return new ResponseEntity<>(allPosts, HttpStatus.OK);
    }

    //    deletePosts
    @DeleteMapping("{id}")
    public ResponseEntity<?> deletePosts(@PathVariable String id) {
        this.postService.deletePosts(id);
        return ResponseEntity.ok().build();
    }
//    updatePosts

    @PutMapping("{id}")
    public ResponseEntity<Post> updatePosts(@RequestBody Post post, @PathVariable String id) {
        Post updatePosts = this.postService.updatePosts(post, id);
        return new ResponseEntity<>(updatePosts, HttpStatus.OK);
    }
}
