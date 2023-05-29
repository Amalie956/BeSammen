package com.example.besammen.domain;

import android.content.Context;
import android.widget.ListView;
import android.widget.Toast;

import com.example.besammen.repository.MessageRepository;

import java.util.ArrayList;
//Abdul
public class MessageService {
    private Context context;
    private MessageRepository chatRepository;

    public MessageService(Context context) {
        this.chatRepository = new MessageRepository();
        this.context = context;
    }

    public void updateDatabase(ListView listViewForMessages, ArrayList<String> arrayListForMessages){
        chatRepository.addMessageToChat(listViewForMessages, arrayListForMessages, context);
    }
    public void addMessage(String username, String message) {
        chatRepository.addMessage(username, message);
        Toast.makeText(context, "Beskeden er sendt. Du kan nu scrolle ned på chatten", Toast.LENGTH_SHORT).show();
    }

}
