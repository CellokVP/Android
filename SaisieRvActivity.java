package fr.gsb;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;

import fr.gsb.rv.entites.Praticiens;
import fr.gsb.rv.modeles.ModeleGSB;
public class SaisieRvActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private ModeleGSB modele ;

    private EditText nbEchantillons;

    private String[] listeMotif = { "Mal à la tête", "Jambe cassé/fouler", "nausée", "Vomissement"} ;

    private String[] coefConfiance = { "0", "1", "2", "3", "4", "5"} ;

    private Spinner motif ;

    private Spinner praticien ;

    private Spinner CoefConfiance ;

    private TextView dateSelectionnee ;

    private GregorianCalendar laDateRapportVisite ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saisie_rv);

        dateSelectionnee = (TextView) findViewById(R.id.date) ;
        praticien = (Spinner) findViewById(R.id.Praticiens) ;
        motif = (Spinner) findViewById(R.id.motifs) ;
        CoefConfiance = (Spinner) findViewById(R.id.coefConfiance) ;

        //String test = modele.listPraticiens();

        ArrayAdapter<String> mo = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                listeMotif
        ) ;

        mo.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        motif.setAdapter(mo);

        ArrayAdapter<String> an = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                coefConfiance
        ) ;

        an.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        CoefConfiance.setAdapter(an);

/*
        ArrayList<Praticiens> lesPraticiens = (ArrayList<Praticiens>) ModeleGSB.getInstance().listPraticiens();

        String test = String.valueOf(lesPraticiens.get(0))) ;

        Log.i("liste praticien : " , test) ;
*/


    }



    public void annuler(View vue){
        Intent enchant = new Intent(this, MenuRVActivity.class) ;
        startActivity(enchant);
    }

    public void valider(View vue){
        Intent enchant = new Intent(this, MenuRVActivity.class) ;
        startActivity(enchant);
    }

    public void saisie(View vue){
        Intent enchant = new Intent(this, SaisieEnchantActivity.class) ;
        startActivity(enchant);
    }

    public void ModifierDate(View vue){

        GregorianCalendar aujourdhui = new GregorianCalendar() ;

        int jour = aujourdhui.get(Calendar.DAY_OF_MONTH) ;
        int mois = aujourdhui.get(Calendar.MONTH) ;
        int annee = aujourdhui.get(Calendar.YEAR) ;

        new DatePickerDialog(this, this, annee, mois, jour).show() ;

    }

    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth){
        String dateRapportVisite = String.format(   "%02d/%02d/%04d" ,
                                                    dayOfMonth,
                                                    monthOfYear + 1,
                                                    year) ;
        Log.i("dateRapportVisite : ", dateRapportVisite) ;
        dateSelectionnee.setText(dateRapportVisite) ;

        laDateRapportVisite = new GregorianCalendar(year, monthOfYear, dayOfMonth) ;

    }


}