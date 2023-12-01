package com.example.mobileapps_testing_codes_use_this_for_practise

import android.content.Intent
import android.os.Bundle
import android.widget.CalendarView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import android.widget.CalendarView.OnDateChangeListener
import android.widget.TextView
import android.widget.Toast
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mobileapps_testing_codes_use_this_for_practise.ui.theme.MobileApps_TESTING_CODES_USE_THIS_FOR_PRACTISETheme

class CalendarPage : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calendar_page)

        val calendarView = findViewById<CalendarView>(R.id.calendarView)

        // Set a listener for date changes
        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            val selectedDate = "$dayOfMonth-${month + 1}/$year"
            val intent = Intent(this, ExpandOnFeelingsPage::class.java)
            intent.putExtra("selectedDate", selectedDate)
            startActivity(intent)


            Toast.makeText(this, "Selected date: $selectedDate", Toast.LENGTH_SHORT).show()
        }

    }
}


