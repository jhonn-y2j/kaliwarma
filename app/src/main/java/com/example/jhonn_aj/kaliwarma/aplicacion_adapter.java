package com.example.jhonn_aj.kaliwarma;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jhonn_aj on 15/11/2016.
 */
public class aplicacion_adapter extends ArrayAdapter<aplicacion> {

    Context mycontext;
    int mylayoutResourceID;
    List<aplicacion> datos;
    boolean vista;

    public aplicacion_adapter(Context context, int layoutResourceID, List<aplicacion> data, boolean vista){

        super(context,layoutResourceID,data);
        this.mycontext=context;
        this.mylayoutResourceID=layoutResourceID;
        this.datos=data;
        this.vista=vista;

    }

    public View getView(int position, View convertView, ViewGroup parent){

        View row=convertView;
        aplicacionHolder holder=null;

        if(row==null){

            LayoutInflater inflater= ((Activity)mycontext).getLayoutInflater();
            row=inflater.inflate(mylayoutResourceID,parent,false);

            holder=new aplicacionHolder();
            holder.imagen=(ImageView)row.findViewById(R.id.image);
            holder.campo1=(TextView)row.findViewById(R.id.campo1);
            if (vista==true) {
                holder.box = (CheckBox) row.findViewById(R.id.checkBox8);
                holder.box.setVisibility(View.VISIBLE);
            }
            row.setTag(holder);

        }
        else{
            holder=(aplicacionHolder) row.getTag();

        }

        aplicacion fila=datos.get(position);
        holder.campo1.setText(fila.getTitle());
        if (vista==true) {
            holder.box.setChecked(fila.isVerificar());
        }
        holder.imagen.setImageResource(fila.getImg_aplication());

        return row;
    }

    static class aplicacionHolder{

        ImageView imagen;
        TextView campo1;
        CheckBox box;

    }

}

