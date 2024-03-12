package fr.gsb;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import fr.gsb.rv.entites.Cadeau;
import fr.gsb.rv.modeles.ModeleGSB;


public class SaisieEnchantActivity extends AppCompatActivity {

    private ListView echantillons;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saisie_enchant);

        echantillons = (ListView) findViewById(R.id.echantillons) ;
        ItemCmdAdapteur adaptateur = new ItemCmdAdapteur(this) ;
        echantillons.setAdapter(adaptateur) ;

    }

    class ItemCmdAdapteur extends ArrayAdapter<Cadeau> {
        ItemCmdAdapteur(Activity contexte){
            super(contexte, R.layout.activity_saisie_enchant, ModeleGSB.getInstance().getLesEchantillons()) ;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            View ligneItem = convertView ;

            if(ligneItem == null){
                LayoutInflater convertisseur ) getLayoutInflater() ;
                ligneItem = convertisseur.inflate(R.layout.activity_saisie_enchant, parent, false) ;
            }

            TextView Echantillon = (TextView) ligneItem.findViewById(R.id.Echantillons) ;
            Echantillon.setText( ModeleGSB.getInstance()
                    .getLesEchantillons()
                    .get( position )
                    .getNom()
            ) ;

            Spinner Echantillons = (Spinner) ligneItem.findViewById(R.id.Echantillons) ;

            ArrayAdapter<String> aaQuantite = new ArrayAdapter<String>(
                    SaisieEnchantActivity.this,
                    android.R.layout.simple_spinner_item,
                    ModeleGSB.getQte()
            ) ;

            aaQuantite.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            spQuantite.setAdapter( aaQuantite ) ;

            int quantite = ModeleGSB.getInstance()
                    .getLesEchantillons()
                    .get( position )
                    .getQte();

            spQuantite.setSelection( quantite ) ;

            spQuantite.setTag( Integer.valueOf( position ) ) ;

            spQuantite.setOnItemSelectedListener(
                    new AdapterView.OnItemSelectedListener(){

                        @Override
                        public void onItemSelected( AdapterView<?> parent , View view , int posQuantite, long id){
                            Integer posEchantillons = (Integer) ((Spinner) view.getParent()).getTag();
                            ModeleGSB.getInstance().getLesEchantillons( posEchantillons ).setQuantite(posQuantite) ;

                        }

                        @Override
                        public void onNothingSelected( AdapterView<?> parent){
                        }

                    }
            ) ;

            return ligneItem ;


        }

    }

}