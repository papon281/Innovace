package com.example.music.Security;

import com.example.music.Dto.PostDto;
import com.example.music.Exception.PostNotFound;
import com.example.music.Model.Posts;
import com.example.music.Repo.PostRepository;
import com.example.music.Sevice.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class PostService {

    @Autowired
    private AuthService authService;
    @Autowired
    private PostRepository postRepository;

    @Transactional
    public List<PostDto> showAllPosts() {
        List<Posts> posts = postRepository.findAll();
        return posts.stream().map(this::mapFromPostToDto).collect(toList());
    }

    @Transactional
    public void createPost(PostDto postDto) {
        Posts post = mapFromDtoToPost(postDto);
        postRepository.save(post);
    }

    @Transactional
    public PostDto readSingleAlbum(String album) {
        Posts post = postRepository.findByAlbum(album).orElseThrow(() -> new PostNotFound("For album " + album));
        return mapFromPostToDto(post);
    }

    @Transactional
    public PostDto readSingleArtist(String artist) {
        Posts post = postRepository.findByArtist(artist).orElseThrow(() -> new PostNotFound("For artist " + artist));
        return mapFromPostToDto(post);
    }

    @Transactional
    public PostDto readSingleGenre(String genre) {
        Posts post = postRepository.findByGenre(genre).orElseThrow(() -> new PostNotFound("For genre " + genre));
        return mapFromPostToDto(post);
    }

    private PostDto mapFromPostToDto(Posts post) {
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setAlbum(post.getAlbum());
        postDto.setArtist(post.getArtist());
        postDto.setGenre(post.getGenre());
        return postDto;
    }

    private Posts mapFromDtoToPost(PostDto postDto) {
        Posts post = new Posts();
        post.setAlbum(postDto.getAlbum());
        post.setArtist(postDto.getArtist());
        post.setGenre(postDto.getGenre());
        return post;
    }
}
