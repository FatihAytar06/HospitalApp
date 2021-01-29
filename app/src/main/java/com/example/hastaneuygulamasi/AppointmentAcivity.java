package com.example.hastaneuygulamasi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.lang.ref.Reference;

public class AppointmentAcivity extends AppCompatActivity {
    Intent intent;
    String date;
    TextView textView;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        firebaseDatabase = FirebaseDatabase.getInstance();
        reference = firebaseDatabase.getReference();
        setContentView(R.layout.activity_appointment_acivity);
        intent = getIntent();
        textView = findViewById(R.id.dateTextView);
        date = intent.getStringExtra("date");
        textView.setText(date);
    }
}