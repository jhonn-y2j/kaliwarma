package com.example.jhonn_aj.kaliwarma;

import android.content.Context;
import android.support.v7.view.menu.ShowableListMenu;
import android.support.v7.widget.ForwardingListener;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jhonn_aj on 15/11/2016.
 */
public class aplicacion_lock_adapter extends RecyclerView.Adapter<aplicacion_lock_adapter.app_lock_holder>{

    LayoutInflater layoutInflater;
    List<aplicacion> aplicacions;

    OnItemClickAppLock onItemClickAppLock;

    public aplicacion_lock_adapter(Context context, List<aplicacion> aplicacions,OnItemClickAppLock onItemClickAppLock){
        this.layoutInflater=LayoutInflater.from(context);
        this.aplicacions=aplicacions;
        this.onItemClickAppLock=onItemClickAppLock;
    }

    @Override
    public app_lock_holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=layoutInflater.inflate(R.layout.layout_item_locks,parent,false);
        return new app_lock_holder(view);
    }

    @Override
    public void onBindViewHolder(app_lock_holder holder, int position) {
        aplicacion app=aplicacions.get(position);
        holder.imgv_app_lock.setImageResource(app.getImg_aplication());
        holder.text_title_lock.setText(app.getTitle());
        holder.text_date_lock.setText(app.getDate());
        holder.text_horario_lock.setText(app.getHorario());
        if (app.isApp_lock()){
            holder.text_lock_msj.setVisibility(View.VISIBLE);
        }else {
            holder.text_lock_msj.setVisibility(View.GONE);
        }
        holder.setOnItemClickAppLock(app,onItemClickAppLock);
        holder.setOntouchItem(app,onItemClickAppLock);

    }

    @Override
    public int getItemCount() {
        return this.aplicacions.size();
    }

    public interface OnItemClickAppLock{
        public void itemClick(aplicacion app);
        public void itemOnTouch(aplicacion app);
    }

    public static  class app_lock_holder extends RecyclerView.ViewHolder{

        ImageView imgv_app_lock;
        ImageView imgv_lock_remove;
        TextView text_title_lock;
        TextView text_date_lock;
        TextView text_horario_lock;
        TextView text_lock_msj;

        LinearLayout layout_select;

        boolean estado=false;

        public app_lock_holder(View itemView) {
            super(itemView);
            imgv_app_lock=(ImageView)itemView.findViewById(R.id.img_app_lock);
            imgv_lock_remove=(ImageView)itemView.findViewById(R.id.img_select_remove);
            text_date_lock=(TextView)itemView.findViewById(R.id.txt_date_lock);
            text_title_lock=(TextView)itemView.findViewById(R.id.txt_title_lock);
            text_horario_lock=(TextView)itemView.findViewById(R.id.txt_horario_lock);
            text_lock_msj=(TextView)itemView.findViewById(R.id.txt_lock_msj);

            layout_select=(LinearLayout)itemView.findViewById(R.id.layout_selection);
        }

        public void setOnItemClickAppLock(final aplicacion app, final OnItemClickAppLock onItemClickAppLock){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickAppLock.itemClick(app);

                }
            });
        }

        public void setOntouchItem(final aplicacion app, final OnItemClickAppLock onItemClickAppLock){
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    onItemClickAppLock.itemOnTouch(app);
                    if (estado==false) {
                        layout_select.setVisibility(View.VISIBLE);
                        estado=true;
                    }else{
                        layout_select.setVisibility(View.GONE);
                        estado=false;
                    }
                    return false;
                }
            });

        }
    }

}
