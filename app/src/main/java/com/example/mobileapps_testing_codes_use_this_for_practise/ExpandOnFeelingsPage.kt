package com.example.mobileapps_testing_codes_use_this_for_practise

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.constraintlayout.widget.ConstraintLayout

class ExpandOnFeelingsPage : ComponentActivity() {

    private lateinit var button: Button
    private lateinit var imageView: ImageView

    // Process adding an image from gallery
    companion object{
        const val IMAGE_REQUEST_CODE = 100
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Transition for getting to the page
        window.requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
        overrideActivityTransition(
            OVERRIDE_TRANSITION_OPEN,
            R.anim.slide_in_right,
            R.anim.slide_out_left
        )

        //Connecting to xml layout
        setContentView(R.layout.expand_on_feelings_page)



        //Setting up Variables for buttons
        findViewById<EditText>(R.id.enterName)
        val awfulButton = findViewById<Button>(R.id.awfulButton)
        val sadButton = findViewById<Button>(R.id.sadButton)
        val okayButton = findViewById<Button>(R.id.okayButton)
        val happyButton = findViewById<Button>(R.id.happyButton)
        val awesomeButton = findViewById<Button>(R.id.awesomeButton)

        //Setting up image button
        button = findViewById(R.id.btn_pick_img)
        imageView = findViewById(R.id.img_save)

        //Being able to choose image
        button.setOnClickListener {
            pickImageGallery()
        }

        //Calling BG background
        val bgcolorsaved = BGValue.bgColourChange
        val colorBg = findViewById<ConstraintLayout>(R.id.expand_on_feelings_colour)
        colorBg.setBackgroundColor(Color.parseColor(bgcolorsaved))

        //Change background based on button
        awfulButton.setOnClickListener {
            BGValue.bgColourChange = "#4C2899"
            colorBg.setBackgroundColor(Color.parseColor("#4C2899"))
        }
        sadButton.setOnClickListener {
            BGValue.bgColourChange = "#6A77F0"
            colorBg.setBackgroundColor(Color.parseColor("#6A77F0"))
        }
        okayButton.setOnClickListener {
            BGValue.bgColourChange = "#F49B55"
            colorBg.setBackgroundColor(Color.parseColor("#F49B55"))
        }
        happyButton.setOnClickListener {
            BGValue.bgColourChange = "#FFB800"
            colorBg.setBackgroundColor(Color.parseColor("#FFB800"))
        }
        awesomeButton.setOnClickListener {
            BGValue.bgColourChange = "#4CB543"
            colorBg.setBackgroundColor(Color.parseColor("#4CB543"))
        }

        //Save button goes to home page
        val goToHomePage = findViewById<Button>(R.id.saveButton)
        goToHomePage.setOnClickListener {
           val toHomePageSave = Intent(this, HomePage::class.java)
            startActivity(toHomePageSave)
        }

        //Cancel button goes to home page
        val goToHomePage2 = findViewById<Button>(R.id.cancelButton)
        goToHomePage2.setOnClickListener {
           val toHomePageCancel = Intent(this, HomePage::class.java)
            startActivity(toHomePageCancel)
        }
    }

    // Adding image from gallery and running code
    private fun pickImageGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == IMAGE_REQUEST_CODE && resultCode == RESULT_OK ){
            imageView.setImageURI(data?.data)
        }
    }
}
