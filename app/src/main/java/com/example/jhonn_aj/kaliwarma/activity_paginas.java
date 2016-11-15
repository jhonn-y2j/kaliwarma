package com.example.jhonn_aj.kaliwarma;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by jhonn_aj on 15/11/2016.
 */
public class activity_paginas extends AppCompatActivity {

    ListView listview;
    ArrayList<aplicacion> datos;
    aplicacion_adapter adapter;
    EditText et1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        et1=(EditText)findViewById(R.id.editText2);

        datos=new ArrayList<>();

        datos.add(new aplicacion(R.drawable.cancelar,"Facebook"));
        datos.add(new aplicacion(R.drawable.cancelar,"Twitter"));


        adapter=new aplicacion_adapter(this,R.layout.list_item_aplication,datos,false);

        listview=(ListView) findViewById(R.id.listView2);

        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                final int posicion=i;

                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(activity_paginas.this);
                dialogo1.setTitle("Importante");
                dialogo1.setMessage("¿ Elimina esta direcciòn web ?");
                dialogo1.setCancelable(false);
                dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        datos.remove(posicion);
                        adapter.notifyDataSetChanged();
                    }
                });
                dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                    }
                });
                dialogo1.show();

            }

        });


    }

    public void agregar(View v) {
        String texto=et1.getText().toString();
        datos.add(new aplicacion(R.drawable.cancelar,texto));
        adapter.notifyDataSetChanged();
        et1.setText("");
    }
}
