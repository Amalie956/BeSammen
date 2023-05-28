package com.example.besammen.domain;

import android.content.Context;
import android.widget.Toast;

import com.example.besammen.repository.ChatRepository;

public class ChatService {
    Context context;
    private ChatRepository chatRepository;

    public ChatService(Context context) {
        this.chatRepository = new ChatRepository();
        this.context = context;
    }

    public void addMessage(String username, String message) {
        chatRepository.addMessage(username, message);
        Toast.makeText(context, "Beskeden er sendt. Du kan nu scrolle ned på chatten", Toast.LENGTH_SHORT).show();
    }
}
