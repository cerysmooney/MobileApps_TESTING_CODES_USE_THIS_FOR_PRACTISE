package com.example.mobileapps_testing_codes_use_this_for_practise

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.ComponentActivity
import androidx.constraintlayout.widget.ConstraintLayout

class GoalsPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Transition
        //Transition for getting to the page
        window.requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
        overrideActivityTransition(
            OVERRIDE_TRANSITION_OPEN,
            R.anim.slide_in_right,
            R.anim.slide_out_left
        )

        //Connecting to Layout
        setContentView(R.layout.goals_page)

        //BG background
        val bgcolorsaved = bgValue.bgColourChange
        val checkcolor = findViewById<ConstraintLayout>(R.id.goals_page_layout)
        checkcolor.setBackgroundColor(Color.parseColor(bgcolorsaved))


        val toHomePageButton = findViewById<ImageButton>(R.id.homePageButtonNav)
        toHomePageButton.setOnClickListener {
            val Intent = Intent(this, HomePage::class.java).also {
                //it.putExtra("saveBackground", backgroundColor)
                startActivity(it)
            }

        }

        val toSoundPageButton = findViewById<ImageButton>(R.id.soundPageButtonNav)
        toSoundPageButton.setOnClickListener {
            val Intent = Intent(this, SoundPage::class.java).also {
                //it.putExtra("saveBackground", backgroundColor)
                startActivity(it)
            }


        }

        val backToHomeButton = findViewById<Button>(R.id.cancelButton)
        backToHomeButton.setOnClickListener {
            val Intent = Intent(this, HomePage::class.java).also {
                //it.putExtra("saveBackground", backgroundColor)
                startActivity(it)
            }
        }
    }
}


