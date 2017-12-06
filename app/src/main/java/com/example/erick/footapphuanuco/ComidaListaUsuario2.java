package com.example.erick.footapphuanuco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;

public class ComidaListaUsuario2 extends AppCompatActivity {

    ListView listaDatos2;
    ArrayList<Datos_comida> Lista2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comida_lista_usuario2);



        listaDatos2 = (ListView) findViewById(R.id.LstDatos_comida2);
        Lista2 = new ArrayList<Datos_comida>();

        Lista2.add(new Datos_comida(1,"Aji de Gallina","9.00 soles","El Viajero Jr Tarapaca y Huallayco","Almuerzos",R.drawable.almuerzo1));
        Lista2.add(new Datos_comida(2,"Estofado de Pollo","8.00 soles","San Felipe","El Viajero Jr Tarapaca y Huallayco",R.drawable.almuerzo2));
        Lista2.add(new Datos_comida(3,"Mondonguito a la Italiana","8.00 soles","Sol de Mayo, Jr 28 de Julio N'894","Almuerzos",R.drawable.almuerzo3));
        Lista2.add(new Datos_comida(4,"Seco de Pollo","8.00 soles","Sol de Mayo, Jr 28 de Julio N'894","Almuerzos",R.drawable.almuerzo4));
        Lista2.add(new Datos_comida(5,"Tallarin de Pollo","12.00 soles","San Felipe","Almuerzos",R.drawable.almuerzo5));
        Lista2.add(new Datos_comida(6,"Pollo a la Brasa","14.00 soles","San Felipe","Almuerzos",R.drawable.almuerzo6));
        Lista2.add(new Datos_comida(7,"Pollo a la Brasa","14.00 soles","San Felipe","Almuerzos",R.drawable.almuerzo6));

        Lista2.add(new Datos_comida(7,"Pollo a la Brasa","14.00 soles","San Felipe","Almuerzos",R.drawable.almuerzo6));



        final AdaptadorUsuario mi_adaptador = new AdaptadorUsuario(getApplicationContext(),Lista2);
        listaDatos2.setAdapter(mi_adaptador);

        listaDatos2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
