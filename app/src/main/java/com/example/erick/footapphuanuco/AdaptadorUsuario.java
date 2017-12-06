package com.example.erick.footapphuanuco;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Erick on 02/12/2017.
 */

public class AdaptadorUsuario extends BaseAdapter {

    Context context;
    List<Datos_comida> ListaObjetos;

    public AdaptadorUsuario(Context context, List<Datos_comida> listaObjetos) {
        this.context = context;
        ListaObjetos = listaObjetos;
    }

    @Override
    public int getCount() {

        return ListaObjetos.size();
    }

    @Override
    public Object getItem(int i) {
        return ListaObjetos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return ListaObjetos.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View vista = view;

        LayoutInflater inflate = LayoutInflater.from(context);

        vista = inflate.inflate(R.layout.itemlistview,null);

        ImageView imageView = (ImageView) vista.findViewById(R.id.imageViewUsuario);
        TextView  nombre = (TextView) vista.findViewById(R.id.textNom);
        TextView  precio = (TextView) vista.findViewById(R.id.textPre);
        TextView  Lugar = (TextView) vista.findViewById(R.id.textLug);
        TextView  Categoria = (TextView) vista.findViewById(R.id.textCat);

        nombre.setText(ListaObjetos.get(i).getNombre().toString());
        precio.setText(ListaObjetos.get(i).getPrecio().toString());
        Lugar.setText(ListaObjetos.get(i).getLugar().toString());
        Categoria.setText(ListaObjetos.get(i).getCategoria().toString());
        imageView.setImageResource(ListaObjetos.get(i).getImagen());

        return vista;

    }
}
