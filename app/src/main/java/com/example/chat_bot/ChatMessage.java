package com.example.chat_bot;

public class ChatMessage {
    public String message,user;

    public ChatMessage(){

    }

    public ChatMessage(String message, String user) {
        this.message = message;
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public String getUser() {
        return user;
    }
}
