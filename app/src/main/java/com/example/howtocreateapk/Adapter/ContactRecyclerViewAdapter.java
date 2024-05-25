package com.example.howtocreateapk.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.howtocreateapk.Model.ContactModel;
import com.example.howtocreateapk.R;

import java.util.ArrayList;

public class ContactRecyclerViewAdapter extends RecyclerView.Adapter<ContactRecyclerViewAdapter.ViewHolder> {

    Context context;
    ArrayList<ContactModel> contactModelArrayList;

    public ContactRecyclerViewAdapter(Context context, ArrayList<ContactModel> contactModelArrayList) {
        this.context = context;
        this.contactModelArrayList = contactModelArrayList;
    }



    @NonNull
    @Override
    public ContactRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.contact_recycler,parent,false);
        ViewHolder  viewHolder=new ViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull ContactRecyclerViewAdapter.ViewHolder holder, int position) {
        Log.w("NANE", " "+contactModelArrayList.get(position).getIdTextViewName() );
        holder.idImageViewProitemView.setImageResource(contactModelArrayList.get(position).getIdImageViewPro());
        holder.idTextViewNameitemView.setText(contactModelArrayList.get(position).getIdTextViewName());
        holder.idTextTimingitemView.setText(contactModelArrayList.get(position).getIdTextTiming());
        holder.idTextViewMsgitemView.setText(contactModelArrayList.get(position).getIdTextViewMsg());
        holder.idTextViewContactitemView.setText(contactModelArrayList.get(position).getIdTextViewContact());

        Log.w("TAG", "Name "+contactModelArrayList.get(position).getIdTextViewName() );
    }


    @Override
    public int getItemCount() {
        return contactModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView idImageViewProitemView;
        TextView idTextViewNameitemView;
        TextView idTextViewContactitemView;
        TextView idTextViewMsgitemView;
        TextView idTextTimingitemView;
        public ViewHolder(@Nullable View  itemView) {
            super(itemView);

            idImageViewProitemView=itemView.findViewById(R.id.idImageViewPro);
            idTextViewNameitemView=itemView.findViewById(R.id.idTextViewName);
            idTextViewContactitemView=itemView.findViewById(R.id.idTextViewContact);
            idTextViewMsgitemView=itemView.findViewById(R.id.idTextViewMsg);
            idTextTimingitemView=itemView.findViewById(R.id.idTextTiming);


        }
    }
}
