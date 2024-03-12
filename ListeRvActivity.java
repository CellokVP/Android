package fr.gsb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import fr.gsb.rv.entites.RapportVisite;

public class ListeRvActivity extends AppCompatActivity {

    TextView Mois ;
    TextView Annee ;
    ListView RapportVisite ;
    TextView Test ;
    private String[] listRapportVisite = { "RP1", "RP2", "RP3", "RP4"} ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_rv);

        String Mois = getIntent().getStringExtra("Mois") ;
        String Annee = getIntent().getStringExtra("Annee") ;

        TextView textView1 = findViewById(R.id.mois) ;
        textView1.setText(Mois);
        TextView textView2 = findViewById(R.id.annee) ;
        textView2.setText(Annee);

        Log.d("Fromage", Mois) ;
        Log.d("Fromage", Annee) ;

        Test = (TextView) findViewById(R.id.test) ;
        RapportVisite = (ListView) findViewById(R.id.RapportVisite) ;
        ArrayAdapter<String> adapteur = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                listRapportVisite
        ) ;
        RapportVisite.setAdapter(adapteur);
        RapportVisite.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View vue, int position, long id){
                String produitSelectionne = listRapportVisite[position];
                Test.setText(produitSelectionne) ;

            }
        }) ;




    }
    public void Valider(View vue){
        Intent visualiser = new Intent(this, VisuRvActivity.class) ;
        startActivity(visualiser);
    }


}