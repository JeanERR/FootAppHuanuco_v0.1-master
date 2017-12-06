package com.example.erick.footapphuanuco;

/**
 * Created by Erick on 18/11/2017.
 */

public class Comida {

    private int id;
    private String nombre;
    private String precio;
    private String tienda;
    private byte[] imagen;

    public Comida(int id, String nombre, String precio, String tienda, byte[] imagen) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.tienda = tienda;
        this.imagen = imagen;
    }

    public int getId() {
        return id;

    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getTienda() {
        return tienda;
    }

    public void setTienda(String tienda) {
        this.tienda = tienda;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }
}
