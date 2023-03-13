package com.example.cours_groupe2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button boutonJeu;

    private Button boutonHighScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boutonJeu = findViewById(R.id.boutonJeu);
        boutonJeu.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, JeuActivity.class);
            startActivity(intent);
        });

        boutonHighScore = findViewById(R.id.boutonHighScore);
        boutonHighScore.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, HighScoreActivity.class);
            startActivity(intent);
        });
    }
}