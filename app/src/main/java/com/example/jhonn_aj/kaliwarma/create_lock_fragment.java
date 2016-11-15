package com.example.jhonn_aj.kaliwarma;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

/**
 * Created by jhonn_aj on 15/11/2016.
 */
public class create_lock_fragment extends Fragment implements TimePickerDialog.OnTimeSetListener {

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

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(getActivity(), activity_aplicaciones.class);
                startActivity(intent);
            }
        });

        return view;

    }

    public void setHora1(View v){

        a=1;
        new timeDialog().onStart();
    }

    public void setHora2(View v){

        a=0;
        new timeDialog().onStart();
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {

    }

}
