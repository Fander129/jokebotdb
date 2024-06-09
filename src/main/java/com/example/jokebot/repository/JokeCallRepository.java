package com.example.jokebot.repository;

import com.example.jokebot.model.JokeCall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JokeCallRepository extends JpaRepository<JokeCall, Long> {
}
