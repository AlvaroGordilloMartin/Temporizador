package com.example.temporizador;

import android.app.Application;
import android.content.IntentFilter;

public class TemporizadorApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        TemporizadorBroadcast temporizadorBroadcast = new TemporizadorBroadcast();
        IntentFilter filter = new IntentFilter("com.example.temporalizador");
        registerReceiver(temporizadorBroadcast,filter,null,null);
    }
}
