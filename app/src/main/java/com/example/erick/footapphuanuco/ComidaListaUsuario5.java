package com.example.erick.footapphuanuco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;

public class ComidaListaUsuario5 extends AppCompatActivity {

    ListView listaDatos5;
    ArrayList<Datos_comida> Lista5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comida_lista_usuario5);




        listaDatos5 = (ListView) findViewById(R.id.LstDatos_comida5);
        Lista5 = new ArrayList<Datos_comida>();

        Lista5.add(new Datos_comida(1,"Chicha Morada","5.00 soles","El viajero Jr.Tarapaca y Huallayco","Bebidas",R.drawable.chichamorada_viajero));
        Lista5.add(new Datos_comida(2,"Inca Kola","6.00 soles","San Felipe","Bebidas",R.drawable.bebida2));
        Lista5.add(new Datos_comida(3,"Coca Cola","6.00 soles","Sol de Mayo","Bebidas",R.drawable.bebida3));
        Lista5.add(new Datos_comida(4,"Chicha de Jora","10.00 soles","Tradiciones Huanuqueñas","Bebidas",R.drawable.bebida4));
        Lista5.add(new Datos_comida(5,"Cerveza Cuzqueña","7.00 soles","El viajero Jr.Tarapaca y Huallayco","Bebidas",R.drawable.bebida5));
        Lista5.add(new Datos_comida(6,"Cerveza Pilsen","7.00 soles","San Felipe","Bebidas",R.drawable.bebida6));


        final AdaptadorUsuario mi_adaptador = new AdaptadorUsuario(getApplicationContext(),Lista5);
        listaDatos5.setAdapter(mi_adaptador);

        listaDatos5.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
