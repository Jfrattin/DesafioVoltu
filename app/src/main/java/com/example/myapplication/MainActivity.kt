package com.example.myapplication
import android.app.ActivityOptions
import android.app.admin.DevicePolicyManager
import android.content.ComponentName
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity()
{

    private var isMaleSelected:Boolean = false
    private var isFemaleSelected:Boolean = true

    private lateinit var viewMale:CardView
    private lateinit var viewFemale:CardView

    override fun onCreate(savedInstanceState: Bundle?) {




        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE)

        // Full size app
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN ,WindowManager.LayoutParams.FLAG_FULLSCREEN)

        //Block app mode Lock Task
        this.startLockTask();
        setContentView(R.layout.activity_main)
        // init component
        iniComponents()
        // Create Click
        initListeners()

    }

    private fun iniComponents() {
        viewMale = findViewById(R.id.viewMale)
        viewFemale = findViewById(R.id.viewFemale)
    }

    private fun initListeners() {
            viewMale.setOnClickListener{
                setGenderColor()
                changeGender()
            }
            viewFemale.setOnClickListener{
                setGenderColor()
                changeGender()

            }
    }

    //function change backgraoud color
    private fun setGenderColor(){
            viewMale.setCardBackgroundColor(getBackgraoundColor(isMaleSelected))
            viewFemale.setCardBackgroundColor(getBackgraoundColor(isFemaleSelected))
    }

    private fun changeGender(){
        isMaleSelected = !isMaleSelected
        isFemaleSelected= !isFemaleSelected

    }
    private fun getBackgraoundColor(isSelectedComponent: Boolean) :Int {
        val colorReference = if (isSelectedComponent) {
            R.color.background_Component
        } else {
            R.color.background_Component_selected
        }
        return ContextCompat.getColor(this, colorReference)
    }

}