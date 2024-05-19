package com.example.howtocreateapk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.skydoves.elasticviews.ElasticButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ElasticButton btnLogout;
    ListView ListViewItem;


    ArrayList<String> arrName= new ArrayList<>();

    //int [] arrNameList=new int[]{12,34,56,34,56};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        btnLogout=findViewById(R.id.btnLogout);
        ListViewItem=findViewById(R.id.ListViewItem);

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

        ArrayAdapter<String> adapterName= new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,arrName   );
        ListViewItem.setAdapter(adapterName);
    }
}