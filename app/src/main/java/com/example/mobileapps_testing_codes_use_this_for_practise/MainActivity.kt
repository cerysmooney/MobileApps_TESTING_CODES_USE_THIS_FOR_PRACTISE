package com.example.mobileapps_testing_codes_use_this_for_practise

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

// Global variable to save BG colour
class bgValue{
    companion object{
        var bgColourChange: String = ""
    }
}
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Splash Screen
        Thread.sleep(1000)
        installSplashScreen()

        //Linked with xml
        setContentView(R.layout.my_layout)

        //Setting Variables
        val seek = findViewById<SeekBar>(R.id.seekBar2)
        val text = findViewById<TextView>(R.id.emotions)
        val owlIMG = findViewById<ImageView>(R.id.owl_images)
        val colorBG = findViewById<ConstraintLayout>(R.id.BGColor)

        //Setting up variables for background changing
        var backgroundColor = "#F49B55"
        bgValue.bgColourChange = backgroundColor

        //Setting up seekbar
        seek?.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar, progress: Int, fromUser: Boolean) {
                Log.d("mainactivity", "seek value: $progress")
                when {
                    progress <= 0 -> text.text = "AWFUL"
                    progress <= 1 -> text.text = "SAD"
                    progress <= 2 -> text.text = "OKAY"
                    progress <= 3 -> text.text = "HAPPY"
                    else -> text.text = "AWESOME"
                }
                when {
                    progress <= 0 -> owlIMG.setImageResource(R.drawable.awful_owl)
                    progress <= 1 -> owlIMG.setImageResource(R.drawable.sadowl)
                    progress <= 2 -> owlIMG.setImageResource(R.drawable.okowl)
                    progress <= 3 -> owlIMG.setImageResource(R.drawable.happyowl)
                    else -> owlIMG.setImageResource(R.drawable.awesomeowl)
                }

                //Change background colour based on values
                backgroundColor = when {
                    progress <= 0 -> "#5F64AB"
                    progress <= 1 -> "#5A9BD4"
                    progress <= 2 -> "#F49B55"
                    progress <= 3 -> "#FAB710"
                    else -> "#5EB45D"
                }
                colorBG.setBackgroundColor(Color.parseColor(backgroundColor))
            }

            //Track mouse click moving the node on the seekbar
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }
            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        }
        )

        //Button for moving onto the next page
        val namePageButton = findViewById<Button>(R.id.button)

        namePageButton.setOnClickListener {

            //Set variable to keep across onto next page
            bgValue.bgColourChange = backgroundColor
            val checkColor = bgValue.bgColourChange

            //Button for moving onto next page
            Log.d("mainactivity", "color check: $checkColor")
            val Intent = Intent(this, NamePage::class.java ).also {
                //it.putExtra("saveBackground", backgroundColor)
                startActivity(it)

            }

        }

        //Skip Button to allow people to skip the decision
        val skipNamePageBttn = findViewById<Button>(R.id.skipButton)
        skipNamePageBttn.setOnClickListener {
            Intent(this, NamePage::class.java).also{
                startActivity(it)
            }
        }
    }
}