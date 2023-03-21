package com.example.cours_groupe2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cours_groupe2.DAO.CalculBaseHelper;
import com.example.cours_groupe2.DAO.CalculDao;
import com.example.cours_groupe2.calculRandom.RandomCalculator;
import com.example.cours_groupe2.model.entities.Calcul;

public class JeuActivity extends AppCompatActivity {
    private String calcul;
    TextView textViewCalcul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeu);
        textViewCalcul = findViewById(R.id.textViewCalcul);
        RandomCalculator randomCalculator = new RandomCalculator();
        textViewCalcul.setText(randomCalculator.getRandomCalculation());
    }
}