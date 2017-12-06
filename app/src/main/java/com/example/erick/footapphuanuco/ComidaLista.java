package com.example.erick.footapphuanuco;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Erick on 18/11/2017.
 */

public class ComidaLista extends AppCompatActivity{

   /* GridView gridView;*/
    ListView listView;
    ArrayList<Comida> list;
    ComidaListaAdapter adapter = null;

    private EditText editText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comida_lista_activity);




       /* gridView = (GridView) findViewById(R.id.gridView);*/
        /////////
        listView = (ListView) findViewById(R.id.listView);
        ///////
        list = new ArrayList<>();

        adapter = new ComidaListaAdapter(this, R.layout.comida_items, list);
        //////
        listView.setAdapter(adapter);
        //////

       /* gridView.setAdapter(adapter);*/


        ///// FILTRAR POR NORMBRE/////////

       // editText = (EditText)  findViewById(R.id.editTextBuscar);



        /*editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

             // adapter.getFilter().filter(charSequence);//


            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });*/


        //////////////////////////



        /////
        SQLiteHelper s=new SQLiteHelper(this);
        s.abrir();
        Cursor cursor = s.getData("SELECT * FROM  FOOD");


        list.clear();

        while (cursor.moveToNext()){


            int id = cursor.getInt(0);
            String nombre = cursor.getString(1);
            String precio = cursor.getString(2);
            String lugar = cursor.getString(3);
            byte [] imagen = cursor.getBlob(4);

            list.add(new Comida(id, nombre, precio, lugar, imagen));
        }
s.cerrar();
        adapter.notifyDataSetChanged();

    }

    public void regresar(View view){

        if (view.getId() == R.id.btnvolveractivity){

            Intent intent = new Intent(ComidaLista.this, MainActivity.class);
            startActivity(intent);
        }
    }
}



