package com.example.mobileapps_testing_codes_use_this_for_practise

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
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
import com.google.android.material.textfield.TextInputEditText
class NamePage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.name_page)
        val rootView = findViewById<ConstraintLayout>(R.id.namePageLayout) // replace with your root layout

        // Retrieve the background color value from the Intent
        val backgroundColor = intent.getIntExtra("saveBackground", android.graphics.Color.WHITE)

        // Set the background color of the root layout
        rootView.setBackgroundColor(backgroundColor)

        val calendarPageButton = findViewById<Button>(R.id.nameButton)
        calendarPageButton.setOnClickListener {
            val Intent = Intent(this, CalendarPage::class.java)
            startActivity(Intent)
        }
    }
}
