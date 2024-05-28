package com.example.howtocreateapk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.howtocreateapk.Adapter.ContactRecyclerViewAdapter;
import com.example.howtocreateapk.Model.ContactModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.skydoves.elasticviews.ElasticButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ElasticButton btnLogout, submit_button;
    ListView ListViewItem;
    RelativeLayout idRelativeLayout;
    Spinner spinner;
    AutoCompleteTextView Txt_Search;

    ArrayList<String> arrName = new ArrayList<>();
    ArrayList<String> arrIds = new ArrayList<>();
    ArrayList<String> ArrayPeogrammingLanguage = new ArrayList<>();
    RecyclerView idRecyclerView;
    ArrayList<ContactModel> contactModelArrayList = new ArrayList<>();
    FloatingActionButton actionButton;
    ImageView profile_image;
    EditText name_input, contact_input, time_input, message_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        btnLogout = findViewById(R.id.btnLogout);
        ListViewItem = findViewById(R.id.ListViewItem);
        spinner = findViewById(R.id.Spainner);
        Txt_Search = findViewById(R.id.Txt_Search);
        idRelativeLayout = findViewById(R.id.idRelativeLayout);
        idRecyclerView = findViewById(R.id.RecyclerView);
        actionButton = findViewById(R.id.OpenDialog);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences("login", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();

                editor.putBoolean("flag", false);

                Intent intent = new Intent(getApplicationContext(), LogIn_Activity.class);
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

        ArrayAdapter<String> adapterName = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_activated_1, arrName);
        ListViewItem.setAdapter(adapterName);

        ListViewItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
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
        arrIds.add("Driving License Card");
        arrIds.add("Ration Card");
        arrIds.add("Class 10th Marksheet ");
        arrIds.add("Class 12th Marksheet ");
        arrIds.add("");

        ArrayAdapter<String> adapterArrayspinnerIds = new ArrayAdapter<>(getApplication(), android.R.layout.simple_list_item_1, arrIds);
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

        ArrayAdapter<String> adapterProgrammingLanguage = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, ArrayPeogrammingLanguage);
        Txt_Search.setAdapter(adapterProgrammingLanguage);
        Txt_Search.setThreshold(1);

        /***
         * cardView
         */
        idRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ListActivity.class);
                startActivity(intent);
            }
        });

        /**
         * RecyclerView
         */

        contactModelArrayList.add(new ContactModel(R.drawable.il, "Akshay  ", "8521616730", "Helllo ,ye", "02:00 AM"));

        contactModelArrayList.add(new ContactModel(R.drawable.neha, "Neha ", "8521616730", "Helllo , Let them to go college", "10:00 AM"));
        contactModelArrayList.add(new ContactModel(R.drawable.poja, "Ankita ", "852616730", "Helllo ,You have to come here", "10:00 AM"));
        contactModelArrayList.add(new ContactModel(R.drawable.i, "Kritika ", "852161730", "Helllo , i am doubtful", "10:00 AM"));
        idRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        ContactRecyclerViewAdapter contactRecyclerViewAdapter = new ContactRecyclerViewAdapter(getApplicationContext(), contactModelArrayList);
        idRecyclerView.setAdapter(contactRecyclerViewAdapter);

        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(MainActivity.this); // Use the current activity context
                dialog.setContentView(R.layout.add_contact);
                submit_button = dialog.findViewById(R.id.submit_button);
                name_input = dialog.findViewById(R.id.name_input);
                profile_image = dialog.findViewById(R.id.profile_image);
                contact_input = dialog.findViewById(R.id.contact_input);
                time_input = dialog.findViewById(R.id.time_input);
                message_input = dialog.findViewById(R.id.message_input);
                submit_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name = name_input.getText().toString();
                        String number = contact_input.getText().toString();
                        String time = time_input.getText().toString();
                        String message = message_input.getText().toString();

                        int profile = R.drawable.poja; // Default profile image
                        // You can add logic to select the actual image from the drawable
                        // based on user input if necessary

                        if (!name.isEmpty() && !number.isEmpty() && !time.isEmpty() && !message.isEmpty()) {
                            contactModelArrayList.add(new ContactModel(profile, name, number, message, time+" AM"));
                            contactRecyclerViewAdapter.notifyItemInserted(contactModelArrayList.size() - 1);
                            idRecyclerView.scrollToPosition(contactModelArrayList.size() - 1);
                            dialog.dismiss(); // Close the dialog after adding the contact
                        } else {
                            Toast.makeText(MainActivity.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                dialog.show();
            }
        });
    }
}
