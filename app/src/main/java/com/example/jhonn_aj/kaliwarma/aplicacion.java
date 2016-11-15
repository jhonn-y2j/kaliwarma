package com.example.jhonn_aj.kaliwarma;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jhonn_aj on 15/11/2016.
 */
public class aplicacion {

    private int img_aplication;
    private String date;
    private String title;
    private String horario;

    private boolean app_lock;

    private boolean verificar;

    public static List<aplicacion> aplicacionList= new ArrayList<>();

    static {
        aplicacionList.add(new aplicacion(R.drawable.ic_menu_gallery,"15/11/2016","Class of English","8:00 AM - 11:00 AM",false));
        aplicacionList.add(new aplicacion(R.drawable.ic_menu_send,"15/11/2016","Class of English","8:00 AM - 11:00 AM",false));
        aplicacionList.add(new aplicacion(R.drawable.ic_menu_share,"15/11/2016","Class of English","8:00 AM - 11:00 AM",false));
        aplicacionList.add(new aplicacion(R.drawable.ic_menu_slideshow,"15/11/2016","Class of DIU","8:00 AM - 11:00 AM",true));
        aplicacionList.add(new aplicacion(R.drawable.ic_menu_camera,"15/11/2016","Class of English","8:00 AM - 11:00 AM",false));
        aplicacionList.add(new aplicacion(R.drawable.ic_menu_manage,"15/11/2016","Class of English","8:00 AM - 11:00 AM",false));
        aplicacionList.add(new aplicacion(R.drawable.ic_menu_send,"15/11/2016","Test Software","8:00 AM - 11:00 AM",false));
        aplicacionList.add(new aplicacion(R.drawable.ic_menu_gallery,"15/11/2016","Class of English","8:00 AM - 11:00 AM",false));
        aplicacionList.add(new aplicacion(R.drawable.ic_menu_share,"15/11/2016","Class of English","8:00 AM - 11:00 AM",false));
        aplicacionList.add(new aplicacion(R.drawable.ic_menu_slideshow,"15/11/2016","Eliminatorias 2016","8:00 AM - 11:00 AM",true));
        aplicacionList.add(new aplicacion(R.drawable.ic_menu_gallery,"15/11/2016","Class of English","8:00 AM - 11:00 AM",false));
    }

    public aplicacion(int img_aplication, String date, String title, String horario, boolean app_lock) {
        this.img_aplication = img_aplication;
        this.date = date;
        this.title = title;
        this.horario = horario;
        this.app_lock = app_lock;
    }

    public aplicacion(){

    }

    public aplicacion(int img_aplication, String title) {
        this.img_aplication = img_aplication;
        this.title = title;
    }

    public aplicacion(int img_aplication, String title, boolean verificar) {
        this.img_aplication = img_aplication;
        this.title = title;
        this.verificar = verificar;
    }

    public boolean isApp_lock() {
        return app_lock;
    }

    public void setApp_lock(boolean app_lock) {
        this.app_lock = app_lock;
    }

    public boolean isVerificar() {
        return verificar;
    }

    public void setVerificar(boolean verificar) {
        this.verificar = verificar;
    }

    public int getImg_aplication() {
        return img_aplication;
    }

    public void setImg_aplication(int img_aplication) {
        this.img_aplication = img_aplication;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}
