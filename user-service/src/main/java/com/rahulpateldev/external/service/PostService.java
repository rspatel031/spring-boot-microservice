package com.rahulpateldev.external.service;

import com.rahulpateldev.entities.Post;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "POST-SERVICE")
public interface PostService {

    @GetMapping("api/v1/posts/users/{id}")
    List<Post> getPostsByUserId(@PathVariable String id);
}
