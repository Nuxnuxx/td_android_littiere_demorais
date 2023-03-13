package com.example.cours_groupe2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResulstatActivity extends AppCompatActivity {

    private TextView textViewResultat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resulstat);
        textViewResultat= findViewById(R.id.textViewResultat);
        Intent intent = getIntent();
        String symbole = intent.getStringExtra("symbol");
        Integer premierTerme = intent.getIntExtra("PREMIER_TERME",0);
        Integer deuxiemeTerme = intent.getIntExtra("DEUXIEME_TERME",0);
        Integer resultat = intent.getIntExtra("RESULTAT",0);

        textViewResultat.setText(premierTerme + symbole + deuxiemeTerme+ " = "+resultat);
    }
}