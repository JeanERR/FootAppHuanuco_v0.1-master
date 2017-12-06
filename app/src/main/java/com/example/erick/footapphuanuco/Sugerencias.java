package com.example.erick.footapphuanuco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Sugerencias extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sugerencias);
    }

    public void sugerenciasclick(View view){

        if (view.getId() == R.id.enviar_sugerencias){

            Toast.makeText(this, "Gracias por su Opinion", Toast.LENGTH_SHORT).show();
        }
        if (view.getId()==R.id.volver_menu){

            Intent intent = new Intent(Sugerencias.this, MenuComida.class);
            startActivity(intent);
        }
    }
}
