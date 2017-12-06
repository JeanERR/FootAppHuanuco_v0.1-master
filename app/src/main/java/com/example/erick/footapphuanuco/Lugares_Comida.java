package com.example.erick.footapphuanuco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Lugares_Comida extends AppCompatActivity {

    ImageView foto;
    TextView nombre;
    TextView precio;
    TextView lugar;
    TextView categoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lugares__comida);

        foto = (ImageView) findViewById(R.id.imgFoto);
        nombre =(TextView) findViewById(R.id.TxtNombre_Comida);
        precio =(TextView) findViewById(R.id.Txt_Precio);
        lugar = (TextView) findViewById(R.id.Txt_Lugar);
        categoria=(TextView) findViewById(R.id.Txt_Categoria);

        Datos_comida obj = (Datos_comida) getIntent().getExtras().getSerializable("objeto");

        foto.setImageResource(obj.getImagen());
        nombre.setText(obj.getNombre());
        precio.setText(obj.getPrecio());
        lugar.setText(obj.getLugar());
        categoria.setText(obj.getCategoria());




    }

    public void sugerencia_ir(View view){

        if (view.getId() == R.id.irSugerencias){

            Intent intent = new Intent(Lugares_Comida.this, Sugerencias.class);
            startActivity(intent);
        }
    }
}
