package com.example.hastaneuygulamasi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    Dialog epicDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseAuth = FirebaseAuth.getInstance();
        epicDialog = new Dialog(this);
    }
    public void MakeAnAppointment(View view){
      epicDialog.setContentView(R.layout.level_interface);
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