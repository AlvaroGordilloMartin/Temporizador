package com.example.temporizador;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class TemporizadorBroadcast extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        //1. Se inicia un servicio (es el caso mas comun)
        //2. Se lanza una notificacion
        //3. Se abre una actividad de nuestra aplicacion

        Intent intentActivity = new Intent(context,TemporizadorActivity.class);
        intentActivity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intentActivity);
    }
}
