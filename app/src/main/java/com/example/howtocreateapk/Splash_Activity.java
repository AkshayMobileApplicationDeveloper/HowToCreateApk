package com.example.howtocreateapk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

public class Splash_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

getSupportActionBar().hide();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences  preferences=getSharedPreferences("login",MODE_PRIVATE);
                Boolean check=preferences.getBoolean("flag",false);


                if(check){
                    Intent intent=new Intent(getApplicationContext(),LogIn_Activity.class);
                    startActivity(
                            intent
                    );
                }
                else{
                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                }

            }
        },3000);

        Log.e("TAG", "onCreate: Log Page Change" );




    }
}