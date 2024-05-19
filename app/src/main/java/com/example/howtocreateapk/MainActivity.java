package com.example.howtocreateapk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.skydoves.elasticviews.ElasticButton;

public class MainActivity extends AppCompatActivity {
    ElasticButton btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        btnLogout=findViewById(R.id.btnLogout);

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

    }
}