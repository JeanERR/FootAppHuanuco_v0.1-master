package com.example.erick.footapphuanuco;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

/**
 * Created by Erick on 18/11/2017.
 */

public class SQLiteHelper extends SQLiteOpenHelper{

//////////////////////////////
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "AppHuanuco.sqlite";
    Context ctx;
    SQLiteHelper dbhelper;
    SQLiteDatabase db;

    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        ctx=context;
    }
//////////////////////////////
    /*
    public SQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
*/
    public void queryData(String sql){

        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);

    }

    public void insertData(String nombre, String precio, String lugar,  byte[] imagen) {
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO FOOD VALUES (NULL, ?, ?, ?, ?)";

        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1, nombre);
        statement.bindString(2, precio);
        statement.bindString(3, lugar);
        statement.bindBlob(4, imagen);

        statement.executeInsert();

    }

    public void  updateData(String nombre, String precio, String lugar, byte[] imagen, int id){

        SQLiteDatabase database = getWritableDatabase();

        String sql = "UPDATE FOOD SET nombre = ?, precio = ?, imagen = ? lugar = ?, WHERE id = ?";
        SQLiteStatement statement = database.compileStatement(sql);

        statement.bindString(1, nombre);
        statement.bindString(2, precio);
        statement.bindString(3,lugar);
        statement.bindBlob(4, imagen);
        statement.bindDouble(5, (double)id);

        statement.execute();
        database.close();
    }

    public void deleteData(int id){

        SQLiteDatabase database = getWritableDatabase();

        String sql = "DELETE FROM FOOD WHERE id = ?";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindDouble(1, (double)id);

        statement.execute();
        database.close();
    }

    public Cursor getData(String sql){

        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql, null);
    }


    ///////////////////////////////////////////
    @Override
    public void onCreate(SQLiteDatabase db) {
        //db.execSQL("CREATE TABLE objeto (id_objeto INT PRIMARY KEY  NOT NULL , imagen BLOB, tipo INT(1) NOT NULL , descripcion VARCHAR(200) NOT NULL , nombre VARCHAR(30), telefono VARCHAR(10) NOT NULL , correo VARCHAR(25) NOT NULL , observaciones VARCHAR(200), fecha VARCHAR(16) )");
        db.execSQL("CREATE TABLE FOOD(Id INTEGER PRIMARY KEY AUTOINCREMENT, nombre VARCHAR, precio VARCHAR, lugar VARCHAR,  image BLOB)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS FOOD");
        onCreate(db);
    }
    public void abrir(){
        dbhelper=new SQLiteHelper(ctx);
        db=dbhelper.getWritableDatabase();
    }
    public void cerrar(){
        db.close();
    }
////////////////////////////////////////////////////////////////////////
}
