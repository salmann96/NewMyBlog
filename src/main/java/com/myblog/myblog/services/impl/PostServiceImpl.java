package com.myblog.myblog.services.impl;

import com.myblog.myblog.dto.PostDto;
import com.myblog.myblog.entity.Post;
import com.myblog.myblog.exception.ResourceNotFoundException;
import com.myblog.myblog.repository.PostRepository;
import com.myblog.myblog.services.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepo;

    public PostServiceImpl(PostRepository postRepo) {
        this.postRepo = postRepo;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        Post post = mapToEntity(postDto);
        Post postEntity = postRepo.save(post);
        PostDto dto = mapToDto(postEntity);
        return dto;
    }

    @Override
    public List<PostDto> getAllPost(PostDto postDto) {
        List<Post> post = postRepo.findAll();
        return post.stream().map(posts -> mapToDto(posts)).collect(Collectors.toList());
    }

    @Override
    public PostDto getPostById(Long id) {
        Post post = postRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("post", "id", id)
        );
        PostDto postDto = mapToDto(post);
        return postDto;
    }

    @Override
    public PostDto updatePostbyId(PostDto postDto, long id) {
        Post post = postRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Post", "Id", id)
        );
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());

        Post updatedPost = postRepo.save(post);
        PostDto postDto1 = mapToDto(updatedPost);
        return postDto1;
    }

    @Override
    public void deletePost(Long id) {
        postRepo.deleteById(id);
    }

    public Post mapToEntity (PostDto postDto){
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        return post;
    }

    public PostDto mapToDto(Post post){
        PostDto dto = new PostDto();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setDescription(post.getDescription());
        dto.setContent(post.getContent());
        return dto;
    }

}
