package com.example.howtocreateapk;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

import com.skydoves.elasticviews.ElasticButton;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class TimePickerActivity extends AppCompatActivity {
    TextView timepickerworld;
    ElasticButton IdBtnElasticButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker);
        getSupportActionBar().hide();

        timepickerworld = findViewById(R.id.timepickerworld);
        IdBtnElasticButton = findViewById(R.id.IdBtnElasticButton);

        timepickerworld.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int hours = calendar.get(Calendar.HOUR_OF_DAY);
                int mins = calendar.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(TimePickerActivity.this, R.style.Theme_HowToCreateApk, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Calendar calendar1 = Calendar.getInstance();
                        calendar1.set(Calendar.HOUR_OF_DAY, hourOfDay);
                        calendar1.set(Calendar.MINUTE, minute);
                        calendar1.setTimeZone(TimeZone.getDefault());
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm a");

                        String time = simpleDateFormat.format(calendar1.getTime());
                        timepickerworld.setText(time);
                    }
                }, hours, mins, false);
                timePickerDialog.show();
            }
        });
    }
}
