package com.example.hastaneuygulamasi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseAuth = FirebaseAuth.getInstance();
    }
    public void MakeAnAppointment(View view){
        Intent intent = new Intent(MainActivity.this, FeedActivity.class);
        startActivity(intent);

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