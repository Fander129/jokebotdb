package com.example.jokebot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class JokeCall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime callTime;

    private Long userId;

    private Long jokeId;

    public JokeCall() {}

    public JokeCall(LocalDateTime callTime, Long userId, Long jokeId) {
        this.callTime = callTime;
        this.userId = userId;
        this.jokeId = jokeId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCallTime() {
        return callTime;
    }

    public void setCallTime(LocalDateTime callTime) {
        this.callTime = callTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getJokeId() {
        return jokeId;
    }

    public void setJokeId(Long jokeId) {
        this.jokeId = jokeId;
    }
}
