package com.example.jokebot.repository;

import com.example.jokebot.model.Joke;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JokeRepository extends JpaRepository<Joke, Long> {
    List<Joke> findTop5ByOrderByRatingDesc();
}
