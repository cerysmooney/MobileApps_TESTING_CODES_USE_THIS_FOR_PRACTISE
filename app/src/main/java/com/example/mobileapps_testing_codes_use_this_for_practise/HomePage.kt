package com.example.mobileapps_testing_codes_use_this_for_practise

import android.content.Intent
import android.content.res.Resources
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.media.Image
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.mobileapps_testing_codes_use_this_for_practise.ui.theme.MobileApps_TESTING_CODES_USE_THIS_FOR_PRACTISETheme

class HomePage : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_page)

        val imageChange = findViewById<ConstraintLayout>(R.id.homePageLayout)

        val imageCross = findViewById<ImageButton>(R.id.imageCross)


        imageCross.setOnClickListener{
            imageCross.setBackgroundResource(R.drawable.check)
        }



        val name = intent.getStringExtra("textSave")
        val introduction = findViewById<TextView>(R.id.intro).apply {
            text = "Hello" + " " + name
        }



        }
}




