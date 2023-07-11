package com.example.myapplication
import android.app.ActivityOptions
import android.app.admin.DevicePolicyManager
import android.content.ComponentName
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.google.android.material.slider.RangeSlider

class MainActivity : AppCompatActivity() {

    private var isnormalSelected: Boolean = false
    private var isturboSelected: Boolean = true

    private var veloc: Float = 0.0f
    private var carg: Float = 0.0f

    private var percentAuto: Float = 1.0f

    private lateinit var viewnormal: CardView
    private lateinit var viewturbo: CardView


    // Var Vel
    private lateinit var tvvel: TextView
    private lateinit var rsVel: RangeSlider

    // var Carga

    private lateinit var tvcarga: TextView
    private lateinit var rscarga: RangeSlider

    // var View autonomia
    private lateinit var clickautonomia: CardView
    private lateinit var tvautonomia: TextView


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE)

        // Full size app
        this.getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        //Block app mode Lock Task
        this.startLockTask();
        setContentView(R.layout.activity_main)
        // init component
        iniComponents()
        // Create Click
        initListeners()

    }

    /// Inicio las variables y componentes
    private fun iniComponents() {
        viewnormal = findViewById(R.id.viewnormal)
        viewturbo = findViewById(R.id.viewturbo)

        tvvel = findViewById(R.id.tvvel)
        rsVel = findViewById(R.id.rsvel)

        tvcarga = findViewById(R.id.viewcarga)
        rscarga = findViewById(R.id.rscarga)

        clickautonomia = findViewById(R.id.clicklautonomia)
        tvautonomia = findViewById(R.id.viewautonomia)
    }

    private fun initListeners() {
        viewnormal.setOnClickListener {
            setGenderColor()
            changeGender()
            percentAuto = 1.0f
        }
        viewturbo.setOnClickListener {
            setGenderColor()
            changeGender()
            percentAuto = 0.75f

        }

        rsVel.addOnChangeListener { _, value, _ ->
            tvvel.text = value.toString();
            veloc=value;
        }

        rscarga.addOnChangeListener { _, value, _ ->
            tvcarga.text = value.toString();
            carg=value;
        }


        clickautonomia.setOnClickListener {
            var auto: Float ;

            auto = (350 - (veloc*1)/22 - (carg*2)/8  ) * percentAuto;

            tvautonomia.text = auto.toString() ;

        }

    }


    //function change background color
    private fun setGenderColor() {
        viewnormal.setCardBackgroundColor(getBackgraoundColor(isnormalSelected))
        viewturbo.setCardBackgroundColor(getBackgraoundColor(isturboSelected))
    }

    private fun changeGender() {
        isturboSelected = !isturboSelected
        isnormalSelected = !isnormalSelected

    }

    private fun getBackgraoundColor(isSelectedComponent: Boolean): Int {
        val colorReference = if (isSelectedComponent) {
            R.color.background_Component
        } else {
            R.color.background_Component_selected
        }
        return ContextCompat.getColor(this, colorReference)
    }



    private fun calculateAutonomia(carga: Float, velocidad: Float, eficiencia:Float ) :Float {


        var resultado: Float

        resultado = (velocidad * carga )*eficiencia

        return resultado
    }

        // Override Function On back disable
    override
    public fun onBackPressed() {
    }
}




