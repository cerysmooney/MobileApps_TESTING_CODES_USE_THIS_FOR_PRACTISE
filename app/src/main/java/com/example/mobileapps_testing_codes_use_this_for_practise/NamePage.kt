package com.example.mobileapps_testing_codes_use_this_for_practise

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
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

class NamePage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.name_page)
//        val owl = findViewById<ImageView>(R.id.nameOwl)
//        val button = findViewById<Button>(R.id.continueButton)

//



////
//        val calendarPageButton = findViewById<Button>(R.id.button3)
//        calendarPageButton.setOnClickListener{
//            val Intent = Intent(this, CalendarPage::class.java)
//            startActivity(Intent)
        }
    }


@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    MobileApps_TESTING_CODES_USE_THIS_FOR_PRACTISETheme {
        Greeting2("Android")
    }
}