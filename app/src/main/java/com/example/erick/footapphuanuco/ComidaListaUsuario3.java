package com.example.erick.footapphuanuco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;

public class ComidaListaUsuario3 extends AppCompatActivity {

    ListView listaDatos3;
    ArrayList<Datos_comida> Lista3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comida_lista_usuario3);




        listaDatos3 = (ListView) findViewById(R.id.LstDatos_comida3);
        Lista3 = new ArrayList<Datos_comida>();

        Lista3.add(new Datos_comida(1, "Arrow Chaufa","12.00 soles", "Chifa el XU","Cenas",R.drawable.cena1));
        Lista3.add(new Datos_comida(2, "Infusiones","3.00 soles","San Felipe","Cenas",R.drawable.cena2));
        Lista3.add(new Datos_comida(3,"Sopa Wantan","6.00 soles","El Viajero Jr Tarapaca y Huallayco","Cenas",R.drawable.cena3));
        Lista3.add(new Datos_comida(4,"Pizza","20.00 soles","Don Sancho","Cenas",R.drawable.cena4));
        Lista3.add(new Datos_comida(5,"Caldo Verde","5.00 soles","Salon de Te Huapri - Dos De Mayo 994","Cenas",R.drawable.cena5));
        Lista3.add(new Datos_comida(6,"Juane de Pollo","14.00 soles","La charapita","Cenas",R.drawable.cena6));


        final AdaptadorUsuario mi_adaptador = new AdaptadorUsuario(getApplicationContext(),Lista3);
        listaDatos3.setAdapter(mi_adaptador);

        listaDatos3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {

                Datos_comida obj =(Datos_comida) parent.getItemAtPosition(i);


                Intent next_Activity =  new Intent(getApplicationContext(), Lugares_Comida.class);
                next_Activity.putExtra("objeto",(Serializable) obj);


                startActivity(next_Activity);

            }
        });
    }
}
