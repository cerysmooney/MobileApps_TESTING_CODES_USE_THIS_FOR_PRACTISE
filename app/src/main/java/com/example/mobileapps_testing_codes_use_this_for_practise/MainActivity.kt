package com.example.mobileapps_testing_codes_use_this_for_practise

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.my_layout)

        val seek = findViewById<SeekBar>(R.id.seekBar2)
        val text = findViewById<TextView>(R.id.emotions)
        val owlIMG = findViewById<ImageView>(R.id.owl_images)
        val colorBG = findViewById<ConstraintLayout>(R.id.BGColor)
        var backgroundColor = "88BB22"
        var startPoint = 0

        seek?.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar, progress: Int, fromUser: Boolean) {
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

                backgroundColor = when {
                    progress <= 0 -> "#4C2899"
                    progress <= 1 -> "#6A77F0"
                    progress <= 2 -> "#F49B55"
                    progress <= 3 -> "#FFB800"
                    else -> "#4CB543"
                }
                colorBG.setBackgroundColor(Color.parseColor(backgroundColor))

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                if (seekBar != null){
                    startPoint = seekBar.progress
                }
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

        val namePageButton = findViewById<Button>(R.id.button)
        namePageButton.setOnClickListener {
            val Intent = Intent(this, NamePage::class.java ).also {
                it.putExtra("saveBackground", backgroundColor)
                startActivity(it)
            }

//            val Intent2 = Intent(this, HomePage::class.java ).also {
//                it.putExtra("saveBackground", backgroundColor)
//            }

        }

    }
}