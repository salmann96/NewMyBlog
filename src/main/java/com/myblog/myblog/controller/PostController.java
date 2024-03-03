package com.myblog.myblog.controller;

import com.myblog.myblog.dto.PostDto;
import com.myblog.myblog.services.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<PostDto> createPost (@RequestBody PostDto postDto){
        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }

    @GetMapping
    public List<PostDto> getallPosts(PostDto postDto){              //getting all posts
        return postService.getAllPost(postDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById (@PathVariable Long id){
        return ResponseEntity.ok( postService.getPostById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost (@RequestBody PostDto postDto, @PathVariable long id){
        PostDto postResponse = postService.updatePostbyId(postDto, id);
        return new ResponseEntity<>(postResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PostDto> deleteById (@PathVariable Long id){
        postService.deletePost(id);
        return ResponseEntity
                .noContent()
                .build();
    }
}
