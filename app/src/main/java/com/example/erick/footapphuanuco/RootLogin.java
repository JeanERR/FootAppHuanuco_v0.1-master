package com.example.erick.footapphuanuco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RootLogin extends AppCompatActivity {


    Button btnroot, btningresaruser, btncrearuser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root_login);

        getSupportActionBar().hide();

    btnroot = (Button) findViewById(R.id.btnRootIngresar);
    btningresaruser = (Button) findViewById(R.id.btningresaruser);
    btncrearuser = (Button) findViewById(R.id.btncrearuser);

    }


    public   void rootgo(View view){

        if (view.getId() == R.id.btnRootIngresar){

            Intent i = new Intent(RootLogin.this, MainActivity.class);
            startActivity(i);
        }

        if (view.getId() == R.id.btningresaruser){
            Intent e = new Intent(RootLogin.this,InicioSesion.class );
            startActivity(e);
        }

        if (view.getId()== R.id.btncrearuser){

            Intent ie = new Intent(RootLogin.this, CrearUsuario.class);
            startActivity(ie);
        }

    }
}
