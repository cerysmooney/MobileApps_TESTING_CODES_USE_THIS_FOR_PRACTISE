package com.example.mobileapps_testing_codes_use_this_for_practise

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.mobileapps_testing_codes_use_this_for_practise.ui.theme.MobileApps_TESTING_CODES_USE_THIS_FOR_PRACTISETheme

class ExpandOnFeelingsPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.expand_on_feelings_page)



        val colorBg = findViewById<ConstraintLayout>(R.id.expand_on_feelings_colour)
        val awfulButton = findViewById<Button>(R.id.awfulButton)
        val sadButton = findViewById<Button>(R.id.sadButton)
        val okayButton = findViewById<Button>(R.id.okayButton)
        val happyButton = findViewById<Button>(R.id.happyButton)
        val awesomeButton = findViewById<Button>(R.id.awesomeButton)


        awfulButton.setOnClickListener{
            colorBg.setBackgroundColor(Color.parseColor("#4C2899"))
        }
        sadButton.setOnClickListener{
            colorBg.setBackgroundColor(Color.parseColor("#6A77F0"))
        }
        okayButton.setOnClickListener{
            colorBg.setBackgroundColor(Color.parseColor("#F49B55"))
        }
        happyButton.setOnClickListener{
            colorBg.setBackgroundColor(Color.parseColor("#FFB800"))
        }
        awesomeButton.setOnClickListener{
            colorBg.setBackgroundColor(Color.parseColor("#4CB543"))
        }


        val goToHomePage = findViewById<Button>(R.id.saveButton)
        goToHomePage.setOnClickListener{
            val Intent = Intent(this,HomePage::class.java)
            startActivity(Intent)
        }
    }

    }
