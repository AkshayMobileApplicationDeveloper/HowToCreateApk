package com.example.howtocreateapk.Adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.howtocreateapk.Model.ContactModel;
import com.example.howtocreateapk.R;

import java.util.ArrayList;

public class ContactRecyclerViewAdapter extends RecyclerView.Adapter<ContactRecyclerViewAdapter.ViewHolder> {
    private Context context;
    private ArrayList<ContactModel> contactModelArrayList;

    public ContactRecyclerViewAdapter(Context context, ArrayList<ContactModel> contactModelArrayList) {
        this.context = context;
        this.contactModelArrayList = contactModelArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.contact_recycler, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ContactModel contactModel = contactModelArrayList.get(position);

        if (contactModel.getProfileImage() instanceof Integer) {
            holder.profileImage.setImageResource((Integer) contactModel.getProfileImage());
        } else if (contactModel.getProfileImage() instanceof Uri) {
            holder.profileImage.setImageURI((Uri) contactModel.getProfileImage());
        }
        holder.name.setText(contactModel.getName());
        holder.phone.setText(contactModel.getPhone());
        holder.message.setText(contactModel.getMessage());
        holder.time.setText(contactModel.getTime());
    }

    @Override
    public int getItemCount() {
        return contactModelArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView profileImage;
        TextView name, phone, message, time;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            profileImage = itemView.findViewById(R.id.profile_image);
            name = itemView.findViewById(R.id.idTextViewName);
            phone = itemView.findViewById(R.id.idTextViewContact);
            message = itemView.findViewById(R.id.idTextViewMsg);
            time = itemView.findViewById(R.id.idTextTiming);
        }
    }
}
