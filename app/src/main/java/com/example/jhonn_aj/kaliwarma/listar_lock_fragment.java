package com.example.jhonn_aj.kaliwarma;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.List;

/**
 * Created by jhonn_aj on 15/11/2016.
 */
public class listar_lock_fragment extends Fragment implements aplicacion_lock_adapter.OnItemClickAppLock{

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    aplicacion_lock_adapter lock_adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view= inflater.inflate(R.layout.fragment_list_lock,container,false);

        recyclerView=(RecyclerView)view.findViewById(R.id.recycler_view);

        layoutManager= new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(layoutManager);

        List<aplicacion> aplicacions=aplicacion.aplicacionList;
        lock_adapter= new aplicacion_lock_adapter(getActivity(),aplicacions,this);
        recyclerView.setAdapter(lock_adapter);

        return view;
    }

    @Override
    public void itemClick(aplicacion app) {
        Log.d(listar_lock_fragment.class.getName(),app.getTitle());
    }

    @Override
    public void itemOnTouch(aplicacion app) {
        Log.d(listar_lock_fragment.class.getName(),app.getTitle()+"tt");
    }


}
