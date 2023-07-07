package com.example.myapplication;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class StartActivityPower extends BroadcastReceiver
{

    @Override
    public void onReceive(Context context, Intent intent) {
        if(Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())){
            Intent activityIntent = new Intent(context, MainActivity.class);
            activityIntent.addFlags(intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(activityIntent);


            //Si la accion boot esta completa inicia



        }
    }
}
