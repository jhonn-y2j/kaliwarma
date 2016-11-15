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

    private boolean verificar;

    public static final List<aplicacion> aplicacionList= new ArrayList<>();

    static {

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
