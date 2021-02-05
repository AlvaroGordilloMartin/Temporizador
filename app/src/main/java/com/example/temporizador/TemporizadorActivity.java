package com.example.temporizador;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TemporizadorActivity extends AppCompatActivity {

    private static final int RQUESTCODE = 123;

    TimePicker timePicker;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timePicker = findViewById(R.id.tpTime);
        button = findViewById(R.id.btStart);

        //Iniciarlizo el temporizador
        timePicker.setIs24HourView(true);
        //Inicializo el boton
        button.setOnClickListener(v -> {
            init();
        });


    }

    /**
     * Segun la version del SDK se construye el temporizador con AlarmManager o JobSchelude
     */
    private void init() {
        initAlarmManager();
    }

    private void initAlarmManager() {
        Intent intent = new Intent("com.example.temporalizador");
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this,RQUESTCODE,intent,0);

        //Gestionar el momento de la alarma
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,timePicker.getHour());
        calendar.set(Calendar.MINUTE,timePicker.getMinute());
        calendar.set(Calendar.SECOND,0);

        //Por si acaso imprimo en el log la hora
        SimpleDateFormat sdft = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        Log.d("Hora",sdft.format(calendar.getTime()));

        //Programo la alarmas
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC,calendar.getTimeInMillis(),pendingIntent);
        finish();
    }
}