package com.example.erick.footapphuanuco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class ComidaListaUsuario extends AppCompatActivity {

    ListView listaDatos;
    ArrayList<Datos_comida> Lista;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comida_lista_usuario);


        ////
        textView = (TextView) findViewById(R.id.filter);
        ///




        listaDatos = (ListView) findViewById(R.id.LstDatos_comida);
        Lista = new ArrayList<Datos_comida>();

        Lista.add(new Datos_comida(1,"Sopa de Patasca","6.00 soles","Polleria el Faraon JR. Micaela Bastidas 324 Paucarbamba","Desayunos",R.drawable.desayuno1));
        Lista.add(new Datos_comida(2,"Caldo Verde","8.00 soles","Polleria el Faraon JR. Micaela Bastidas 324 Paucarbamba","Desayunos",R.drawable.desayuno2));
        Lista.add(new Datos_comida(3,"Cafe","5.00 soles","Salon de Te Huapri - Dos De Mayo 994","Desayunos",R.drawable.desayuno3));
        Lista.add(new Datos_comida(4,"Pie de Manzana","4.00 soles","San Felipe","Desayunos",R.drawable.desayuno4));
        Lista.add(new Datos_comida(5,"Pan con Queso","3.00 soles","San Felipe","Desayunos",R.drawable.desayuno5));
        Lista.add(new Datos_comida(6,"Ensalada de Fruta","6.00 soles","Vale Vale","Desayunos",R.drawable.desayuno6));



        final AdaptadorUsuario mi_adaptador = new AdaptadorUsuario(getApplicationContext(),Lista);
        listaDatos.setAdapter(mi_adaptador);

        ///////////

        ////////////

        listaDatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {

                Datos_comida obj =(Datos_comida) parent.getItemAtPosition(i);


                Intent next_Activity =  new Intent(getApplicationContext(), Lugares_Comida.class);
                next_Activity.putExtra("objeto",(Serializable) obj);


                startActivity(next_Activity);

            }
        });

        textView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {



            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}
