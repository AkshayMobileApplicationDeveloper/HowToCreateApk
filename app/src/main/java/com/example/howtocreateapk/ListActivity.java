package com.example.howtocreateapk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    ListView ListViewListClass;
    ArrayList<String> addName=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        getSupportActionBar().hide();

        ListViewListClass=findViewById(R.id.ListViewListClass);
        addName.add("Amit");
        addName.add("Shandhaya");
        addName.add("Sumit");
        addName.add("Suman");
        addName.add("Kumar");
        addName.add("Rohit");

        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<>(getApplication(), android.R.layout.simple_list_item_1,addName);
        ListViewListClass.setAdapter(arrayAdapter);


    }
}