package com.example.erick.footapphuanuco;

import java.io.Serializable;

/**
 * Created by Erick on 02/12/2017.
 */

public class Datos_comida implements Serializable{
    private  int Id;
    private String Nombre;
    private String Precio;
    private String Lugar;
    private String Categoria;
    private  int Imagen;


    public Datos_comida(int id, String nombre, String precio, String lugar, String categoria, int imagen) {
        Id = id;
        Nombre = nombre;
        Precio = precio;
        Lugar = lugar;
        Categoria = categoria;
        Imagen = imagen;

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String precio) {
        Precio = precio;
    }

    public String getLugar() {
        return Lugar;
    }

    public void setLugar(String lugar) {
        Lugar = lugar;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public int getImagen() {
        return Imagen;
    }

    public void setImagen(int imagen) {
        Imagen = imagen;
    }


}
