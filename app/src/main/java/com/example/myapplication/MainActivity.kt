package com.example.myapplication
import android.app.ActivityOptions
import android.app.admin.DevicePolicyManager
import android.content.ComponentName
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager

class MainActivity : AppCompatActivity()
{


    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE)

        // Full size app
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN ,WindowManager.LayoutParams.FLAG_FULLSCREEN)

        //Block app mode Lock Task
        this.startLockTask();

        setContentView(R.layout.activity_main)
    }
    

}