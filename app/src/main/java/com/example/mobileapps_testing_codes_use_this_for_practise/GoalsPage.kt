package com.example.mobileapps_testing_codes_use_this_for_practise

import android.content.DialogInterface
import android.os.Bundle
import android.graphics.Color
import android.widget.RelativeLayout
import androidx.activity.ComponentActivity

class GoalsPage : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.goals_page)

        //BG background
        val bgcolorsaved = bgValue.bgColourChange
        val checkcolor = findViewById<RelativeLayout>(R.id.goalsPageLayout)
        checkcolor.setBackgroundColor(Color.parseColor(bgcolorsaved))
        }
    }
