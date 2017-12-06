package com.example.erick.footapphuanuco;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.Manifest;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    EditText edtNombre, edtPrecio, edtLugar;
    Button btnElegir, btnAgregar, btnLista;
    ImageView imageView;

    Button act;

    final int REQUEST_CODE_GALLERY = 999;

    public static SQLiteHelper sqLiteHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        init();

/*
        sqLiteHelper = new SQLiteHelper(this, "AppHuanuco.sqlite", null, 1);
        sqLiteHelper.queryData("CREATE TABLE IF NOT EXISTS FOOD(Id INTEGER PRIMARY KEY AUTOINCREMENT, nombre VARCHAR, precio VARCHAR, lugar VARCHAR,  image BLOB)");
*/
        btnElegir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCompat.requestPermissions(
                        MainActivity.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        REQUEST_CODE_GALLERY
                );
            }
        });

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    ////
                    byte[] bytes = imageViewToByte(imageView);
                    Bitmap bitmap= BitmapFactory.decodeByteArray(bytes, 0, bytes.length);


                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                    byte[] bai = baos.toByteArray();
                    /////

                    SQLiteHelper s=new SQLiteHelper(MainActivity.this);
                    s.insertData(
                            edtNombre.getText().toString().trim(),
                            edtPrecio.getText().toString().trim(),
                            edtLugar.getText().toString().trim(),
                            bai
                    );
                    Toast.makeText(getApplicationContext(), "Se agrego correctamente!", Toast.LENGTH_SHORT).show();
                    edtNombre.setText("");
                    edtPrecio.setText("");
                    edtLugar.setText("");
                    imageView.setImageResource(R.mipmap.ic_launcher);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });



        btnLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ComidaLista.class);
                startActivity(intent);
            }
        });



    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if (requestCode == REQUEST_CODE_GALLERY) {

            if (grantResults.length >0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {


                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, REQUEST_CODE_GALLERY);
            }

            else {

                Toast.makeText(getApplicationContext(), "NO TIENES PERMISOS PARA ACCEDER A LOS ARCHIVOS", Toast.LENGTH_SHORT).show();
            }
            return;
        }


        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode ==  REQUEST_CODE_GALLERY && resultCode == RESULT_OK && data!= null){

            Uri uri =  data.getData();

            try {

                InputStream inputStream = getContentResolver().openInputStream(uri);

                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);

                imageView.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    private void init() {

        edtNombre = (EditText) findViewById(R.id.editTextNombre);
        edtPrecio = (EditText) findViewById(R.id.editTextPrecio);
        edtLugar = (EditText) findViewById(R.id.editTextLugar);
        btnElegir = (Button) findViewById(R.id.BotonSeleccionar);
        btnAgregar = (Button) findViewById(R.id.BotonAgregar);
        btnLista = (Button) findViewById(R.id.botonVerPlatos);
        imageView = (ImageView) findViewById(R.id.imageView);
    }

    private byte[] imageViewToByte(ImageView image) {
        Bitmap bitmap = ((BitmapDrawable) image.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }

    public  void salir(View view){

        if (view.getId() == R.id.btnvolver){
            Intent intent = new Intent(MainActivity.this,InicioSesion.class);
            startActivity(intent);

        }
    }
}