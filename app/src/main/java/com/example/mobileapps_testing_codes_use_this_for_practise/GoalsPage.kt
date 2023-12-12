package com.example.mobileapps_testing_codes_use_this_for_practise

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.constraintlayout.widget.ConstraintLayout

class GoalsPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Connecting to Layout
        setContentView(R.layout.goals_page)

        //BG background
        val bgcolorsaved = bgValue.bgColourChange
        val checkcolor = findViewById<ConstraintLayout>(R.id.goals_page_layout)
        checkcolor.setBackgroundColor(Color.parseColor(bgcolorsaved))
    }
}


