package com.example.music.Repo;

import com.example.music.Model.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Posts, Long> {
    Optional<Posts> findByAlbum(String album);
    Optional<Posts> findByArtist(String artist);
    Optional<Posts> findByGenre(String album);
}
