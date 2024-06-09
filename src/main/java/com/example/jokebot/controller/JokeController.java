package com.example.jokebot.controller;

import com.example.jokebot.model.Joke;
import com.example.jokebot.service.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jokes")
public class JokeController {

    @Autowired
    private JokeService jokeService;

    @GetMapping
    public ResponseEntity<List<Joke>> getAllJokes() {
        List<Joke> jokes = jokeService.getAllJokes();
        return new ResponseEntity<>(jokes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Joke> getJokeById(@PathVariable Long id) {
        Joke joke = jokeService.getJokeById(id);
        if (joke != null) {
            return new ResponseEntity<>(joke, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Joke> createJoke(@RequestBody Joke joke) {
        Joke createdJoke = jokeService.createJoke(joke);
        return new ResponseEntity<>(createdJoke, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Joke> updateJoke(@PathVariable Long id, @RequestBody Joke joke) {
        Joke updatedJoke = jokeService.updateJoke(id, joke);
        if (updatedJoke != null) {
            return new ResponseEntity<>(updatedJoke, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJoke(@PathVariable Long id) {
        boolean deleted = jokeService.deleteJoke(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/top5")
    public ResponseEntity<List<Joke>> getTop5Jokes() {
        List<Joke> top5Jokes = jokeService.getTop5Jokes();
        return new ResponseEntity<>(top5Jokes, HttpStatus.OK);
    }
}
