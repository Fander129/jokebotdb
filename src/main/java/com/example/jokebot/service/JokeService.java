package com.example.jokebot.service;

import com.example.jokebot.model.Joke;
import com.example.jokebot.repository.JokeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JokeService {

    @Autowired
    private JokeRepository jokeRepository;

    public List<Joke> getAllJokes() {
        return jokeRepository.findAll();
    }

    public Joke getJokeById(Long id) {
        return jokeRepository.findById(id).orElse(null);
    }

    public Joke createJoke(Joke joke) {
        return jokeRepository.save(joke);
    }

    public Joke updateJoke(Long id, Joke joke) {
        if (jokeRepository.existsById(id)) {
            joke.setId(id);
            return jokeRepository.save(joke);
        } else {
            return null;
        }
    }

    public boolean deleteJoke(Long id) {
        if (jokeRepository.existsById(id)) {
            jokeRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public List<Joke> getTop5Jokes() {
        // Пример получения топ-5 шуток
        return jokeRepository.findTop5ByOrderByRatingDesc();
    }
}
