package com.example.jokebot.service;

import com.example.jokebot.model.Joke;
import com.example.jokebot.repository.JokeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;
import java.util.Random;

@Service
public class TelegramBotService extends TelegramLongPollingBot {

    @Autowired
    private JokeRepository jokeRepository;

    @Override
    public String getBotUsername() {
        return "Jokes12908Bot"; // замените на имя вашего бота
    }

    @Override
    public String getBotToken() {
        return "7403933204:AAGtENEAngok2jMdUBFIaDGrLpBP7TJU3qo"; // замените на токен вашего бота
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();

            if (messageText.equalsIgnoreCase("/joke")) {
                sendRandomJoke(chatId);
            } else {
                sendMessage(chatId, "Отправьте /joke для получения случайной шутки.");
            }
        }
    }

    private void sendRandomJoke(long chatId) {
        List<Joke> jokes = jokeRepository.findAll();
        if (!jokes.isEmpty()) {
            Random random = new Random();
            Joke joke = jokes.get(random.nextInt(jokes.size()));
            sendMessage(chatId, joke.getText());
        } else {
            sendMessage(chatId, "Извините, в базе данных пока нет шуток.");
        }
    }

    private void sendMessage(long chatId, String text) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(text);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
