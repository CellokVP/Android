package fr.gsb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class VisuRvActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visu_rv);
    }

    public void Enchant(View vue){
        Intent enchant = new Intent(this, VisuEnchantAcitivity.class);
        startActivity(enchant);
    }

}