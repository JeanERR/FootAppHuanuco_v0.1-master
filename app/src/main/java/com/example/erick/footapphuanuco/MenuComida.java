package com.example.erick.footapphuanuco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MenuComida extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_comida);

        getSupportActionBar().hide();


    }

    public void go(View view){

        if (view.getId() == R.id.img1){

            startActivity(new Intent(MenuComida.this, ComidaListaUsuario.class));


        }
        if (view.getId() == R.id.img2){

            startActivity(new Intent(MenuComida.this, ComidaListaUsuario2.class));


        }
        if (view.getId() == R.id.img3){

            startActivity(new Intent(MenuComida.this, ComidaListaUsuario3.class));


        }
        if (view.getId() == R.id.img4){

            startActivity(new Intent(MenuComida.this, ComidaListaUsuario4.class));


        }
        if (view.getId() == R.id.img5){

            startActivity(new Intent(MenuComida.this, ComidaListaUsuario5.class));


        }
    }


}
