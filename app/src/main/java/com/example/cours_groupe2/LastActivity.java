package com.example.cours_groupe2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.cours_groupe2.DAO.CalculBaseHelper;
import com.example.cours_groupe2.DAO.CalculDao;
import com.example.cours_groupe2.model.entities.Calcul;

public class LastActivity extends AppCompatActivity {
    private CalculDao calculDao;
    TextView textViewDernierCalcul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);
        calculDao = new CalculDao(new CalculBaseHelper(this, "BDD", 1));
        Calcul monCalcul = calculDao.lastOrNull();
        textViewDernierCalcul = findViewById(R.id.textViewDernierCalcul);
        textViewDernierCalcul.setText(monCalcul.getPremierElement() + monCalcul.getSymbole() + monCalcul.getDeuxiemeElement() + " = " + monCalcul.getResultat());


    }
}