package com.emericoapp.mychat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.emericoapp.mychat.adapter.ChatAdapter;
import com.emericoapp.mychat.model.ChatModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private EditText messagbox;
    private Button btnSend;
    final ArrayList<ChatModel> chatModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.chat_list);
        messagbox = findViewById(R.id.et_chat_box);
        btnSend = findViewById(R.id.btn_chat_send);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i =1;
                i ++;
                ChatModel chatModel = new ChatModel();
                chatModel.setId(i);
                chatModel.setMe(true);
                chatModel.setMessage(messagbox.getText().toString().trim());

                chatModels.add(chatModel);

                ChatAdapter chatAdapter = new ChatAdapter(chatModels, MainActivity.this);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                recyclerView.setAdapter(chatAdapter);
                messagbox.setText("");

            }
        });
    }
}
