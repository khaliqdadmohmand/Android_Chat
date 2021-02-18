package com.emericoapp.mychat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.emericoapp.mychat.R;
import com.emericoapp.mychat.model.ChatModel;

import java.util.ArrayList;

public class ChatAdapter  extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {

    private ArrayList<ChatModel> chatModels;
    private Context context;

    public ChatAdapter(ArrayList<ChatModel>chatModels, Context context){
        this.chatModels = chatModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.my_messag, parent, false);
        ViewHolder holder = new ViewHolder( listItem);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.message.setText(chatModels.get(position).getMessage());

    }

    @Override
    public int getItemCount() {
        return chatModels.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView message;

        public ViewHolder(View itemView){
            super(itemView);
            this.message = itemView.findViewById(R.id.message_body);
        }
    }
}
