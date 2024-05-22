package com.example.howtocreateapk.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.howtocreateapk.Model.ModelChat;
import com.example.howtocreateapk.R;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {
    private Context context;
    private ArrayList<ModelChat> modelChats;

    public ContactAdapter(Context context, ArrayList<ModelChat> modelChats) {
        this.context = context;
        this.modelChats = modelChats;
    }

    @NonNull
    @Override
    public ContactAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_recycler, parent, false);
        return new ContactAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactAdapter.ViewHolder holder, int position) {

        holder.idTextViewName.setText(modelChats.get(position).toString());
        holder.idTextViewContact.setText(modelChats.get(position).toString());
        holder.idTextViewMsg.setText(modelChats.get(position).toString());
        holder.idTextTiming.setText(modelChats.get(position).toString());

    }

    @Override
    public int getItemCount() {
        return modelChats.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView idImageViewPro;
        TextView idTextViewName, idTextViewContact, idTextViewMsg, idTextTiming;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            idImageViewPro = itemView.findViewById(R.id.idImageViewPro);
            idTextViewName = itemView.findViewById(R.id.idTextViewName);
            idTextViewContact = itemView.findViewById(R.id.idTextViewContact);
            idTextViewMsg = itemView.findViewById(R.id.idTextViewMsg);
            idTextTiming = itemView.findViewById(R.id.idTextTiming);
        }
    }
}
