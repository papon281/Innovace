package com.example.music.Controller;

import com.example.music.Dto.PostDto;
import com.example.music.Security.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts/")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity createPost(@RequestBody PostDto postDto) {
        postService.createPost(postDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PostDto>> showAllPosts() {
        return new ResponseEntity<>(postService.showAllPosts(), HttpStatus.OK);
    }

    @GetMapping("/get/{album}")
    public ResponseEntity<PostDto> getSingleAlbum(@PathVariable @RequestBody String album) {
        return new ResponseEntity<>(postService.readSingleAlbum(album), HttpStatus.OK);
    }

    @GetMapping("/get/{artist}")
    public ResponseEntity<PostDto> getSingleArtist(@PathVariable @RequestBody String artist) {
        return new ResponseEntity<>(postService.readSingleArtist(artist), HttpStatus.OK);
    }

    @GetMapping("/get/{artist}")
    public ResponseEntity<PostDto> getSingleGenre(@PathVariable @RequestBody String genre) {
        return new ResponseEntity<>(postService.readSingleGenre(genre), HttpStatus.OK);
    }
}
