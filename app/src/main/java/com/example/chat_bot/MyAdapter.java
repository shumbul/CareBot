package com.example.chat_bot;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private Context context;
    private List<ChatMessage> chatMessages;


    public MyAdapter(Context context, List<ChatMessage> userProfiles) {
        this.context = context;
        this.chatMessages = userProfiles;
    }

    //First a view is created by inflating message layout
    //Later a view a created fore this view and returned
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.message,viewGroup,false);
        return new ViewHolder(v);
    }

    //This function binds the data with the initialised viewholder elements
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        ChatMessage chatMessage = chatMessages.get(i);

        if (chatMessage.getUser().equals("user")) {

            viewHolder.rightText.setText(chatMessage.getMessage());
            viewHolder.rightText.setVisibility(View.VISIBLE);
            viewHolder.leftText.setVisibility(View.GONE);
        }
        else {
            viewHolder.leftText.setText(chatMessage.getMessage());
            viewHolder.rightText.setVisibility(View.GONE);
            viewHolder.leftText.setVisibility(View.VISIBLE);
        }
    }
    // Returns the count of items pushed into the Recyclerview
    @Override
    public int getItemCount() {
        return chatMessages.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView leftText,rightText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            leftText = itemView.findViewById(R.id.leftText);
            rightText = itemView.findViewById(R.id.rightText);

        }
    }
}