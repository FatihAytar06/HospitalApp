package com.example.hastaneuygulamasi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    Dialog epicDialog;
    Button closeButton, appointmentBtn;
    CalendarView calendarView;
    String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseAuth = FirebaseAuth.getInstance();
        epicDialog = new Dialog(this);
    }
    public void MakeAnAppointment(View view){
        epicDialog.setContentView(R.layout.level_interface);
        closeButton = epicDialog.findViewById(R.id.closeButton);
        appointmentBtn = epicDialog.findViewById(R.id.appointmentButton);
        calendarView = epicDialog.findViewById(R.id.calendarView);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                epicDialog.cancel();
            }
        });
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                date = dayOfMonth + "/" + (month+1) + "/" + year ;
            }
        });
        appointmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AppointmentAcivity.class);
                intent.putExtra("date", date);
                startActivity(intent);
            }
        });
      epicDialog.setCancelable(false);
      epicDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
      epicDialog.show();
    }

    public void AskQuestion(View view){
        Intent intent = new Intent(MainActivity.this, PickDoctor.class);
        startActivity(intent);
    }

    public void Exit(View view){
        firebaseAuth.signOut();
        Intent intent = new Intent(MainActivity.this, LogInScreen.class);
        startActivity(intent);
        finish();
    }

    public void GoAccountInfo(View view){
        Intent intent = new Intent(MainActivity.this, AccountActivity.class);
        startActivity(intent);
    }
}