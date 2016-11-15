package com.example.jhonn_aj.kaliwarma;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;

import java.util.Calendar;

/**
 * Created by jhonn_aj on 15/11/2016.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class timeDialog extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Iniciar con el tiempo actual
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        // Retornar en nueva instancia del dialogo selector de tiempo
        return new TimePickerDialog(
                getActivity(),
                (TimePickerDialog.OnTimeSetListener) getContext(),
                hour,
                minute,
                DateFormat.is24HourFormat(getActivity()));
    }

}
