package com.example.mobileapps_testing_codes_use_this_for_practise

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.view.Window
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.constraintlayout.widget.ConstraintLayout
import java.text.SimpleDateFormat
import java.util.Date


class HomePage : ComponentActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private val cross1KEY = "cross1_key"
    private val cross2KEY = "cross2_key"
    private val cross3KEY = "cross3_key"

    // Declare boolean variables to track the state of each button
    private var isCross1Checked = false
    private var isCross2Checked = false
    private var isCross3Checked = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Transition for getting to the page
        window.requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
        overrideActivityTransition(
            OVERRIDE_TRANSITION_OPEN,
            R.anim.slide_in_right,
            R.anim.slide_out_left
        )
        //Connecting to Layout
        setContentView(R.layout.home_page)

        //BG background
        val bgcolorsaved = BGValue.bgColourChange
        val checkcolor = findViewById<ConstraintLayout>(R.id.homePageLayout)
        checkcolor.setBackgroundColor(Color.parseColor(bgcolorsaved))

        //Getting date and displaying in textview
        val textView: TextView = findViewById(R.id.dateAndTime)
        val simpleDateFormat = SimpleDateFormat("dd.MM.yyyy")
        val currentDateAndTime: String = simpleDateFormat.format(Date())
        textView.text = currentDateAndTime


        // Initialize SharedPreferences
        sharedPreferences = getPreferences(Context.MODE_PRIVATE)

        // Calling values for the image buttons to allow for changing background
        val imageCross = findViewById<ImageButton>(R.id.imageCross)
        val imageCross2 = findViewById<ImageButton>(R.id.imageCross2)
        val imageCross3 = findViewById<ImageButton>(R.id.imageCross3)

        // Retrieve the saved state for each button
        isCross1Checked = sharedPreferences.getBoolean(cross1KEY, false)
        isCross2Checked = sharedPreferences.getBoolean(cross2KEY, false)
        isCross3Checked = sharedPreferences.getBoolean(cross3KEY, false)

        // Set the initial background state for each button
        updateButtonState(imageCross, isCross1Checked)
        updateButtonState(imageCross2, isCross2Checked)
        updateButtonState(imageCross3, isCross3Checked)

        // Changing the background on click for each button
        imageCross.setOnClickListener {
            isCross1Checked = !isCross1Checked
            updateButtonState(imageCross, isCross1Checked)
            saveState(cross1KEY, isCross1Checked)
        }

        imageCross2.setOnClickListener {
            isCross2Checked = !isCross2Checked
            updateButtonState(imageCross2, isCross2Checked)
            saveState(cross2KEY, isCross2Checked)
        }

        imageCross3.setOnClickListener {
            isCross3Checked = !isCross3Checked
            updateButtonState(imageCross3, isCross3Checked)
            saveState(cross3KEY, isCross3Checked)
        }


        // Button for getting goals page
        val goalsPageButton = findViewById<ImageButton>(R.id.goalsPageButton)
        goalsPageButton.setOnClickListener {
            val goalsPageArrowButton = Intent(this, GoalsPage::class.java)
            startActivity(goalsPageArrowButton)
        }

        //Displaying hello and the name chosen from the name page
        val callName = NameValue.nameData
        findViewById<TextView>(R.id.intro).apply {
            text = getString(R.string.hello_with_space) + callName
        }

        //Button for Expanding on Feelings
        val expandOnFeelingsPageButton = findViewById<ImageButton>(R.id.imagePlusIcon)
        expandOnFeelingsPageButton.setOnClickListener {
            val expandOnFeelingsPageScreen = Intent(this, ExpandOnFeelingsPage::class.java)
            startActivity(expandOnFeelingsPageScreen)
        }


        //NAVIGATION BAR

        //Button for getting to the sounds page
        val homeSoundPageButton = findViewById<ImageButton>(R.id.soundPageButtonNav)
        homeSoundPageButton.setOnClickListener {
            val soundPageScreen = Intent(this, SoundPage::class.java)
            startActivity(soundPageScreen)
        }

        // Button for getting goals page
        val homeGoalsPageButton = findViewById<ImageButton>(R.id.goalsPageButtonNav)
        homeGoalsPageButton.setOnClickListener {
            val goalsPageScreen = Intent(this, GoalsPage::class.java)
            startActivity(goalsPageScreen)
        }


    }

    //Updating the function of the button
    private fun updateButtonState(imageButton: ImageButton, isChecked: Boolean) {
        if (isChecked) {
            imageButton.setBackgroundResource(R.drawable.check)
        } else {
            imageButton.setBackgroundResource(R.drawable.cross)
        }
    }

    private fun saveState(key: String, value: Boolean) {
        sharedPreferences.edit().putBoolean(key, value).apply()
    }
}



