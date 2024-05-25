package com.example.howtocreateapk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;


import com.example.howtocreateapk.Adapter.ContactRecyclerViewAdapter;
import com.example.howtocreateapk.Model.ContactModel;
import com.skydoves.elasticviews.ElasticButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ElasticButton btnLogout;
    ListView ListViewItem;
    CardView cardView;
    Spinner spinner;
    AutoCompleteTextView Txt_Search;

    ArrayList<String> arrName= new ArrayList<>();
    ArrayList<String> arrIds= new ArrayList<>();
    ArrayList<String> ArrayPeogrammingLanguage= new ArrayList<>();
    RecyclerView idRecyclerView;


    ArrayList<ContactModel> contactModelArrayList =new ArrayList<>();






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        btnLogout=findViewById(R.id.btnLogout);
        ListViewItem=findViewById(R.id.ListViewItem);
        spinner=findViewById(R.id.Spainner);
        Txt_Search=findViewById(R.id.Txt_Search);
        cardView=findViewById(R.id.CardView);
        idRecyclerView=findViewById(R.id.RecyclerView);



        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences=getSharedPreferences("login",MODE_PRIVATE);
                SharedPreferences.Editor editor= preferences.edit();

                editor.putBoolean("flag",false);

                Intent intent=new Intent(getApplicationContext(),LogIn_Activity.class);
                startActivity(intent);
            }
        });

        arrName.add("Akshay");
        arrName.add("Pooja");
        arrName.add("Neha");
        arrName.add("Amit");
        arrName.add("Shandhaya");
        arrName.add("Geeta");
        arrName.add("Kiran");
        arrName.add("Kusum");
        arrName.add("Mukesh");
        arrName.add("Rohit");
        arrName.add("Sharma");
        arrName.add("Pankaj");
        arrName.add("Mohit");
        arrName.add("RamKumar");
        arrName.add("Sandeep");
        arrName.add("Aman");

        ArrayAdapter<String> adapterName= new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_activated_1,arrName );
        ListViewItem.setAdapter(adapterName);


        ListViewItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Toast.makeText(MainActivity.this, "Good", Toast.LENGTH_SHORT).show();
                }
            }
        });

        /*
        Spinner
         */

        arrIds.add("Adhar card");
        arrIds.add("Pan Card");
        arrIds.add("Voter Card");
        arrIds.add("Driving  License Card");
        arrIds.add("Ration Card");
        arrIds.add("Class 10th Marksheet ");
        arrIds.add("Class 12th Marksheet ");
        arrIds.add("");

        ArrayAdapter<String>adapterArrayspinnerIds= new ArrayAdapter<>(getApplication(),android.R.layout.simple_list_item_1,arrIds);
        spinner.setAdapter(adapterArrayspinnerIds);


        /*
        AutoCompleteTextView
         */
        ArrayPeogrammingLanguage.add("C");
        ArrayPeogrammingLanguage.add("Java");
        ArrayPeogrammingLanguage.add("PHP");
        ArrayPeogrammingLanguage.add("Dart");
        ArrayPeogrammingLanguage.add("Python");
        ArrayPeogrammingLanguage.add("C++");
        ArrayPeogrammingLanguage.add("JavaScript");

        ArrayAdapter<String> adapterProgrammingLanguage=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,ArrayPeogrammingLanguage);
        Txt_Search.setAdapter(adapterProgrammingLanguage);
        Txt_Search.setThreshold(1);

        /***
         * cardView
         */
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ListActivity.class);
                startActivity(intent);
            }
        });


        /**
         * RecyclerView
         */


        contactModelArrayList.add(new ContactModel(R.drawable.neha,"Neha ","8521616730","Helllo , Let them to go college","10:00 AM"));
        contactModelArrayList.add(new ContactModel(R.drawable.poja,"Ankita ","852616730","Helllo ,You have to come here","10:00 AM"));
        contactModelArrayList.add(new ContactModel(R.drawable.i,"Kritika ","852161730","Helllo , i am doubtful","10:00 AM"));
        idRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        ContactRecyclerViewAdapter contactRecyclerViewAdapter=new ContactRecyclerViewAdapter(getApplicationContext(),contactModelArrayList);
        idRecyclerView.setAdapter(contactRecyclerViewAdapter);



    }
}