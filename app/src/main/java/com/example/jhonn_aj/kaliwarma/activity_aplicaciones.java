package com.example.jhonn_aj.kaliwarma;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jhonn_aj on 15/11/2016.
 */
public class activity_aplicaciones extends AppCompatActivity {

    ListView listview;
    Button boton;
    aplicacion_adapter adapter;
    List<aplicacion> datos;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activtiy_aplication);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        boton=(Button) findViewById(R.id.button7);

        datos=new ArrayList<>();

        datos.add(new aplicacion(R.drawable.facebook,"Facebook",false));
        datos.add(new aplicacion(R.drawable.twiter,"Twiter",false));
        datos.add(new aplicacion(R.drawable.messenger,"Messenger",false));
        datos.add(new aplicacion(R.drawable.whatsapp,"Whatssapp",false));
        datos.add(new aplicacion(R.drawable.instagram,"Instagram",false));
        datos.add(new aplicacion(R.drawable.chrome,"Chrome",false));

        findViewById(R.id.checkBox9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cargar_datos();
            }
        });

        adapter=new aplicacion_adapter(this,R.layout.list_item_aplication,datos,true);

        listview=(ListView) findViewById(R.id.listview);

        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView texto=(TextView)view.findViewById(R.id.campo1);
                Toast.makeText(getApplicationContext(),texto.getText(),Toast.LENGTH_SHORT).show();
            }
        });

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(activity_aplicaciones.this, activity_paginas.class);
                startActivity(intent);
            }
        });

    }

    private void cargar_datos(){

        int i=0;
        for(aplicacion a:datos){

            //a.setVerificar(true);
            //datos[i]=a;
            datos.get(i).setVerificar(true);
            i++;
        }

        aplicacion_adapter adapter=new aplicacion_adapter(this,R.layout.list_item_aplication,datos,true);
        listview.setAdapter(adapter);

    }

}
