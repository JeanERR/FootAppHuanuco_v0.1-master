package com.example.erick.footapphuanuco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;

public class ComidaListaUsuario4 extends AppCompatActivity {

    ListView listaDatos4;
    ArrayList<Datos_comida> Lista4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comida_lista_usuario4);



        listaDatos4 = (ListView) findViewById(R.id.LstDatos_comida4);
        Lista4 = new ArrayList<Datos_comida>();

        Lista4.add(new Datos_comida(1,"Salchipapa","6.00 soles","San Felipe","Comida Rapida",R.drawable.rapida1));
        Lista4.add(new Datos_comida(2,"Boster de Pollo","8.00 soles","El Viajero Jr Tarapaca y Huallayco","Comida Rapida",R.drawable.rapida2));
        Lista4.add(new Datos_comida(3,"Pollo a la Brasa","14.00 soles","San Felipe Grill","Comida Rapida",R.drawable.rapida3));
        Lista4.add(new Datos_comida(4,"Hamburguesa Especial","5.00 soles","MegaDelicias","Comida Rapida",R.drawable.rapida4));
        Lista4.add(new Datos_comida(5,"Papa Rellena","4.00 soles","MegaDelicias","Comida Rapida",R.drawable.rapida6));
        Lista4.add(new Datos_comida(6,"Papa Rellena","4.00 soles","MegaDelicias","Comida Rapida",R.drawable.rapida6));



        final AdaptadorUsuario mi_adaptador = new AdaptadorUsuario(getApplicationContext(),Lista4);
        listaDatos4.setAdapter(mi_adaptador);
        listaDatos4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
