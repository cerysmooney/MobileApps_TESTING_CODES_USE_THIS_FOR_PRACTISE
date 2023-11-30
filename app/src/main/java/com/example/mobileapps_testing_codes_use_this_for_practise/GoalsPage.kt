package com.example.mobileapps_testing_codes_use_this_for_practise

import android.content.Intent
import android.os.Bundle
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
import com.example.mobileapps_testing_codes_use_this_for_practise.ui.theme.MobileApps_TESTING_CODES_USE_THIS_FOR_PRACTISETheme

class GoalsPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.goals_page)

        //Calling values for the image buttons to allow for changing background
        val imageCross = findViewById<ImageButton>(R.id.imageCross)
        val imageCross2 = findViewById<ImageButton>(R.id.imageCross2)
        val imageCross3 = findViewById<ImageButton>(R.id.imageCross3)


        //Changing the background on click for each button
        imageCross.setOnClickListener{
            imageCross.setBackgroundResource(R.drawable.check)
        }
        imageCross2.setOnClickListener{
            imageCross2.setBackgroundResource(R.drawable.check)
        }
        imageCross3.setOnClickListener{
            imageCross3.setBackgroundResource(R.drawable.check)
        }


        //Button for getting to goals page
        val homeGoalsPageButton = findViewById<ImageButton>(R.id.goBack)
        homeGoalsPageButton.setOnClickListener{
            val Intent = Intent(this,HomePage::class.java)
            startActivity(Intent)
        }
    }
}