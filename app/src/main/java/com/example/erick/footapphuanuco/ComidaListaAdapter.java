package com.example.erick.footapphuanuco;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Erick on 18/11/2017.
 */

public class ComidaListaAdapter extends BaseAdapter {

    private Context context;
    private  int layout;
    private ArrayList<Comida> foodsList;


    public ComidaListaAdapter(Context context, int layout, ArrayList<Comida> foodsList) {
        this.context = context;
        this.layout = layout;
        this.foodsList = foodsList;
    }

    @Override
    public int getCount() {
        return foodsList.size();
    }

    @Override
    public Object getItem(int position) {
        return foodsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    private class ViewHolder{

        ImageView imageView;
        TextView textoNombre, textoPrecio, textoLugar;

    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        View row = view;
        ViewHolder holder = new ViewHolder();


        if (row == null){

            LayoutInflater inflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate( layout, null);

            holder.textoNombre = (TextView) row.findViewById(R.id.textoNombre);
            holder.textoPrecio= (TextView) row.findViewById(R.id.textoPrecio);
            holder.textoLugar = (TextView) row.findViewById(R.id.textoLugar);
            holder.imageView = (ImageView) row.findViewById(R.id.ImagenComida);
            row.setTag(holder);

        }
        else {

            holder = (ViewHolder) row.getTag();

        }
            Comida comida = foodsList.get(position);

        holder.textoNombre.setText(comida.getNombre());
        holder.textoPrecio.setText(comida.getPrecio());
        holder.textoLugar.setText(comida.getTienda());

        byte[] foodimagen = comida.getImagen();
        Bitmap bitmap = BitmapFactory.decodeByteArray(foodimagen, 0 , foodimagen.length);
        holder.imageView.setImageBitmap(bitmap);

        return row ;
    }
}
