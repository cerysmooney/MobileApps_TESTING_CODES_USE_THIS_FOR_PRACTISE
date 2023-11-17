package com.example.mobileapps_testing_codes_use_this_for_practise

import android.content.ContentValues.TAG
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
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
        val bgcolorsaved = intent.getStringExtra("saveBackground")
        val editText = findViewById<EditText>(R.id.enterName)
       val checkcolor = findViewById<ConstraintLayout>(R.id.namePageLayout)

       // Log.d(TAG, checkcolor)

       checkcolor.setBackgroundColor(Color.parseColor(bgcolorsaved))

//        if (bgcolorsaved != null) {
//
//        }
        val calendarPageButton = findViewById<Button>(R.id.nameButton)
        calendarPageButton.setOnClickListener {
            val name = editText.text.toString()
            val Intent = Intent(this, HomePage::class.java).also{
                it.putExtra("textSave", name)
                startActivity(it)
            }
//            startActivity(Intent)
        }
    }
}
