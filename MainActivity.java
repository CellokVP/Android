package fr.gsb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import fr.gsb.rv.entites.Visiteur;
import fr.gsb.rv.modeles.ModeleGSB;
import fr.gsb.rv.technique.Session;
import android.widget.CheckBox ;
import android.content.SharedPreferences ;
import android.preference.PreferenceManager ;

public class MainActivity extends AppCompatActivity {
    private EditText etMatricule ;
    private EditText etMdp ;
    private TextView echec ;
    private ModeleGSB modele ;

    private Session session ;

    private SharedPreferences sharedPreferences ;

    private CheckBox souvenirDeMoi ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("GSB_RV_ACTIVITY", "onCreate() : Création de l'activité principale") ;

        etMatricule = findViewById(R.id.matricule);
        etMdp = findViewById(R.id.mdp);

        modele = ModeleGSB.getInstance();

        souvenirDeMoi = findViewById(R.id.souvenir) ;

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        if(sharedPreferences.getBoolean("se_souvenir_de_moi", false)){
            etMatricule.setText(sharedPreferences.getString("matricule", ""));
            etMdp.setText(sharedPreferences.getString("mdp", ""));
            souvenirDeMoi.setChecked(true);
        }

    }

    public void valider(View vue){
        String matricule = etMatricule.getText().toString() ;
        String mdp = etMdp.getText().toString() ;



        SharedPreferences.Editor editor = sharedPreferences.edit() ;
        if(souvenirDeMoi.isChecked()){
            editor.putString("matricule", matricule) ;
            editor.putString("mdp", mdp);
            editor.putBoolean("se_souvenir_de_moi", true) ;
        } else{
            editor.remove("matricule") ;
            editor.remove("mdp") ;
            editor.remove("se_souvenir_de_moi") ;
        }
        editor.apply();

        Visiteur test = ModeleGSB.getInstance().seConnecter(matricule, mdp) ;

        if(test != null){
            echec = findViewById(R.id.erreur);
            echec.setText("reussi");
            Log.i("GSB_RV_ACTIVITY", "seConnecter() : Connexion Ok (Prénom Nom)") ;
            Intent go = new Intent(this, MenuRVActivity.class) ;
            startActivity(go);
        }
        else{
            etMatricule.setText("");
            etMdp.setText("");
            echec = findViewById(R.id.erreur);
            echec.setText("rater");
            Log.i("GSB_RV_ACTIVITY", "seConnecter() : Connexion Nok");
        }


    }


    public void annuler(View vue){
        EditText ResetMatricule = findViewById(R.id.matricule) ;
        ResetMatricule.setText("");
        EditText ResetMdp = findViewById(R.id.mdp) ;
        ResetMdp.setText("");
        Log.i("GSB_RV_ACTIVITY", "annuler() : Initialisation des champs.") ;
    }


}