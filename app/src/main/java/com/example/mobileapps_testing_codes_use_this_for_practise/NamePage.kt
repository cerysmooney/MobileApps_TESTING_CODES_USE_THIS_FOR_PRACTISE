package com.example.mobileapps_testing_codes_use_this_for_practise


import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.constraintlayout.widget.ConstraintLayout

//Create global variable for saving the name
class NameValue {
    companion object {
        var nameData: String = ""
    }
}

class NamePage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Transition animation
        overrideActivityTransition( OVERRIDE_TRANSITION_OPEN, R.anim.slide_in_right, R.anim.slide_out_left)
        setContentView(R.layout.name_page)

        // Calling variables to sav bg colour from previous page
        val bgcolorsaved = BGValue.bgColourChange
        val editText = findViewById<EditText>(R.id.enterName)
        val checkcolor = findViewById<ConstraintLayout>(R.id.namePageLayout)


        checkcolor.setBackgroundColor(Color.parseColor(bgcolorsaved))

        // Button to go to next page
        val calendarPageButton = findViewById<Button>(R.id.nextButton)
        calendarPageButton.setOnClickListener {

            // save entered name from EditText
            NameValue.nameData = editText.text.toString()

            // Next button goes to homepage
            Intent(this, HomePage::class.java).also{
                startActivity(it)
            }
        }

        // Button to go back to previous page
        val emotionPageButton = findViewById<Button>(R.id.emotionButton)
        emotionPageButton.setOnClickListener {

            // Back button goes to MainActivity (how are you feeling) page
          Intent(this, MainActivity::class.java).also {
                //it.putExtra("textSave",name)
                startActivity(it)
            }
        }

        // Button to skip name page and go to the homepage
        val skipHome = findViewById<Button>(R.id.skipToHomeButton)
        skipHome.setOnClickListener {

            // Button goes to homepage
            Intent(this, HomePage::class.java).also {

                startActivity(it)
            }
        }
    }
}
