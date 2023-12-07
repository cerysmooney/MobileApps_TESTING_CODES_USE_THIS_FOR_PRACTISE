package com.example.mobileapps_testing_codes_use_this_for_practise

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.CalendarView
import androidx.activity.ComponentActivity
import android.widget.FrameLayout
import android.widget.Toast



class CalendarPage : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calendar_page)

        val calendarView = findViewById<CalendarView>(R.id.calendarView)



        // Set a listener for date changes
//        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
//            val selectedDate = "$dayOfMonth-${month + 1}/$year"
//            Toast.makeText(this, "Selected date: $selectedDate", Toast.LENGTH_SHORT).show()
//
//            val selectedDateCircle = findViewById<View>(R.id.selectedDateCircle)
//            selectedDateCircle.visibility = View.VISIBLE
//
//            val layoutParams = FrameLayout.LayoutParams(
//                circleContainer.layoutParams.width,
//                circleContainer.layoutParams.height
//            )
//            //layoutParams.gravity = Gravity.CENTER
//            //selectedDateCircle.layoutParams = layoutParams
//
//            val intent = Intent(this, ReflectionPage::class.java)
//            intent.putExtra("selectedDate", selectedDate)
//            startActivity(intent)
//        }

    }
}


