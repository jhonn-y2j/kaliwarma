package com.example.jhonn_aj.kaliwarma;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

/**
 * Created by jhonn_aj on 15/11/2016.
 */
public class create_lock_fragment extends Fragment  {

    private TextView mTimeDisplay;
    private Button mPickTime1;
    private Button mPickTime2;
    private Button boton;
    private TextView hora1;
    private TextView hora2;
    private int mHour;
    private int mMinute;
    static final int TIME_DIALOG_ID = 0;
    int a=0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view= inflater.inflate(R.layout.fragment_create_lock,container,false);

        hora1=(TextView) view.findViewById(R.id.textView7);
        hora2=(TextView) view.findViewById(R.id.textView8);
        mPickTime1=(Button) view.findViewById(R.id.button2);
        mPickTime2=(Button)view.findViewById(R.id.button3);
        boton=(Button)view.findViewById(R.id.button5);

        mPickTime1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();
                int hour = c.get(Calendar.HOUR_OF_DAY);
                int minute = c.get(Calendar.MINUTE);
                TimePickerDialog timePickerDialog= new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        String hora=i+":"+i1;
                        hora1.setText(hora);
                        Log.d(create_lock_fragment.class.getName(),"Mostrar Time Picker :) 01" + i + i1);
                    }
                },hour,minute, android.text.format.DateFormat.is24HourFormat(getActivity()));
                timePickerDialog.show();
            }
        });

        mPickTime2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendar = Calendar.getInstance();
                int yy = calendar.get(Calendar.YEAR);
                int mm = calendar.get(Calendar.MONTH);
                int dd = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePicker = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        String date = "Date"+String.valueOf(year) +"-"+String.valueOf(monthOfYear)
                                +"-"+String.valueOf(dayOfMonth);
                        hora2.setText(date);
                        //Log.d(create_lock_fragment.class.getName(),"Mostrar Time Picker :) 02" + date);
                    }
                }, yy, mm, dd);
                datePicker.show();
            }
        });

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(getActivity(), activity_aplicaciones.class);
                startActivity(intent);
            }
        });

        return view;

    }

}
