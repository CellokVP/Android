package fr.gsb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.util.Log;
import android.view.View;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class RechercheRvActivity extends AppCompatActivity {

    private static final String [] Mois={ "Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Décembre" } ;
    private static final String [] Année = { "2021", "2022", "2023", "2024" } ;

    Spinner mois ;
    Spinner annee ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche_rv);

        mois = (Spinner) findViewById(R.id.mois) ;
        annee = (Spinner) findViewById(R.id.annee) ;

        ArrayAdapter<String> mo = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                Mois
        ) ;

        mo.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        mois.setAdapter(mo);

        ArrayAdapter<String> an = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                Année
        ) ;

        an.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        annee.setAdapter(an);




    }

    public void MoisAnnée(View vue){
        String Mois = mois.getSelectedItem().toString();
        String Annee = annee.getSelectedItem().toString() ;
        Log.d("Fromage", Mois) ;
        Log.d("Fromage", Annee) ;
        Intent intent = new Intent(getApplicationContext(), ListeRvActivity.class) ;
        intent.putExtra("Mois", Mois) ;
        intent.putExtra("Annee", Annee) ;

        startActivity(intent);

    }

    public void Lister(View vue){
        Intent liste = new Intent(this, ListeRvActivity.class) ;
        startActivity(liste);
    }
}