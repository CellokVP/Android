package fr.gsb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;

import android.os.Bundle;

public class MenuRVActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void Consulter(View vue){
        Intent consulter = new Intent(this, RechercheRvActivity.class) ;
        startActivity(consulter);
    }
    public void Saisir(View vue){
        Intent saisir = new Intent(this, SaisieRvActivity.class) ;
        startActivity(saisir);
    }

}