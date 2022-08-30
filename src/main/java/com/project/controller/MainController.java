package com.project.controller;

import com.project.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    private MessageChannel output;

    @PostMapping("/publish")
    public Book publishEvent(@RequestBody Book book) {

        output.send(MessageBuilder.withPayload(book).build());

        return book;

    }

}