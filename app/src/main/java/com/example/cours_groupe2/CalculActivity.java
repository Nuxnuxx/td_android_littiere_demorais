package com.example.cours_groupe2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cours_groupe2.DAO.CalculBaseHelper;
import com.example.cours_groupe2.DAO.CalculDao;
import com.example.cours_groupe2.model.entities.Calcul;

public class CalculActivity extends AppCompatActivity {
    private TextView textViewCalcul;
    private Button boutonPlus;
    private Button boutonDivide;
    private Button boutonSubstract;
    private Button boutonMultiply;
    private Button bouton1;
    private Button bouton2;
    private Button bouton3;
    private Button bouton4;
    private Button bouton5;
    private Button bouton6;
    private Button bouton7;
    private Button bouton8;
    private Button bouton9;
    private Button bouton0;

    private Integer premierTerme = 0;
    private Integer deuxiemeTerme = 0;
    private TypeOperationEnum typeOperation;

    private CalculDao calculDao;

    private String calcul = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcul);
        calculDao= new CalculDao(new CalculBaseHelper(this,"BDD",1));
        textViewCalcul = findViewById(R.id.textViewCalcul);
        boutonDivide = findViewById(R.id.button_divide);
        boutonDivide.setOnClickListener(view -> {
            ajouterSymbole(TypeOperationEnum.DIVIDE);
        });
        boutonPlus = findViewById(R.id.button_plus);
        boutonPlus.setOnClickListener(view -> {
            ajouterSymbole(TypeOperationEnum.ADD);
        });
        bouton0 = findViewById(R.id.buttonZero);
        bouton0.setOnClickListener(view -> {
            ajouterChiffre(0);
        });
        bouton1 = findViewById(R.id.button_1);
        bouton1.setOnClickListener(view -> {
            ajouterChiffre(1);
        });
        bouton2 = findViewById(R.id.button_2);
        bouton2.setOnClickListener(view -> {
            ajouterChiffre(2);
        });
        bouton3 = findViewById(R.id.button_3);
        bouton3.setOnClickListener(view -> {
            ajouterChiffre(3);
        });
        bouton4 = findViewById(R.id.button_4);
        bouton4.setOnClickListener(view -> {
            ajouterChiffre(4);
        });
        bouton5 = findViewById(R.id.button_5);
        bouton5.setOnClickListener(view -> {
            ajouterChiffre(5);
        });
        bouton6 = findViewById(R.id.button_6);
        bouton6.setOnClickListener(view -> {
            ajouterChiffre(6);
        });
        bouton7 = findViewById(R.id.button_7);
        bouton7.setOnClickListener(view -> {
            ajouterChiffre(7);
        });
        bouton8 = findViewById(R.id.button_8);
        bouton8.setOnClickListener(view -> {
            ajouterChiffre(8);
        });
        bouton9 = findViewById(R.id.button_9);
        bouton9.setOnClickListener(view -> {
            ajouterChiffre(9);
        });
        boutonSubstract = findViewById(R.id.button_substract);
        boutonSubstract.setOnClickListener(view -> {
            ajouterSymbole(TypeOperationEnum.SUBSTRACT);
        });
        boutonMultiply = findViewById(R.id.button_multiply);
        boutonMultiply.setOnClickListener(view -> {
            ajouterSymbole(TypeOperationEnum.MULTIPLY);
        });

    }

    private void ajouterSymbole(TypeOperationEnum typeOperation) {
        if (this.typeOperation != null) {
            Toast.makeText(this, getString(R.string.ERROR_ALREADY_HAVE_CALCUL_TYPE), Toast.LENGTH_LONG).show();
        } else {
            this.typeOperation = typeOperation;
            majTextView();
        }
    }

    private void ajouterChiffre(Integer chiffre) {
        if (this.typeOperation == null) {
            if (premierTerme <= 9999) {
                premierTerme = 10 * premierTerme + chiffre;
                majTextView();
            } else {
                Toast.makeText(this, getString(R.string.ERROR_NUMBER_TOO_HIGH), Toast.LENGTH_LONG).show();
            }
        } else {
            if (deuxiemeTerme <= 9999) {
                deuxiemeTerme = 10 * deuxiemeTerme + chiffre;
                majTextView();
            } else {
                Toast.makeText(this, getString(R.string.ERROR_NUMBER_TOO_HIGH), Toast.LENGTH_LONG).show();
            }
        }
    }

    private void majTextView() {
        if (typeOperation == null) {
            textViewCalcul.setText("" + premierTerme);
        } else {
            textViewCalcul.setText(premierTerme + typeOperation.getSymbole() + deuxiemeTerme);
        }
    }

    private void ajouteCharactere(String character) {
        calcul += character;
        textViewCalcul.setText(calcul);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.toolbar, menu);
        MenuItem boutonNettoyer = menu.findItem(R.id.toolbar_clear);
        boutonNettoyer.setOnMenuItemClickListener(view -> {
            textViewCalcul.setText("");
            calcul = "";
            this.typeOperation = null;
            return true;
        });

        MenuItem boutonCalcul = menu.findItem(R.id.toolbar_calcul);
        boutonCalcul.setOnMenuItemClickListener(view -> {
            return faisLeCalcul();
        });

        return super.onCreateOptionsMenu(menu);
    }

    private boolean faisLeCalcul() {
        Integer resultat=0;
        if(verifieLeCalcul()){
            switch (typeOperation){
                case ADD:
                    resultat =premierTerme+deuxiemeTerme;
                    break;
                case SUBSTRACT:
                    resultat = premierTerme-deuxiemeTerme;
                    break;
                case DIVIDE:
                    resultat = premierTerme/deuxiemeTerme;
                    break;
                case MULTIPLY:
                    resultat= premierTerme*deuxiemeTerme;
            }
            Calcul monCalcul = new Calcul();
            monCalcul.setPremierElement(premierTerme);
            monCalcul.setDeuxiemeElement(deuxiemeTerme);
            monCalcul.setResultat(resultat);
            monCalcul.setSymbole(typeOperation.getSymbole());
            calculDao.create(monCalcul);
            Intent intent = new Intent(this,ResulstatActivity.class);
            intent.putExtra("PREMIER_TERME",premierTerme);
            intent.putExtra("symbol",typeOperation.getSymbole());
            intent.putExtra("DEUXIEME_TERME",deuxiemeTerme);
            intent.putExtra("RESULTAT",resultat);
            startActivity(intent);
        }
        return true;
    }

    private boolean verifieLeCalcul() {
        if ((premierTerme == 0 || deuxiemeTerme == 0 || typeOperation == null)) {
            Toast.makeText(this, getString(R.string.MALFORMED_CALCUL), Toast.LENGTH_LONG).show();
            return false;
        } else {
            return true;
        }
    }
}