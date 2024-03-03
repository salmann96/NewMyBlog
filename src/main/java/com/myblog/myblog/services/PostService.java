package com.myblog.myblog.services;

import com.myblog.myblog.dto.PostDto;
import com.myblog.myblog.entity.Post;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PostService {

    public PostDto createPost(PostDto postDto);

    List<PostDto> getAllPost(PostDto postDto);

    PostDto getPostById(Long id);

    PostDto updatePostbyId(PostDto postDto, long id);

    public void deletePost(Long id);
}