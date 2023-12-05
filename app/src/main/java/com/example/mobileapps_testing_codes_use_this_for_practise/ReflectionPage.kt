package com.example.mobileapps_testing_codes_use_this_for_practise

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
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
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.app.ActivityCompat.startActivityForResult
import com.example.mobileapps_testing_codes_use_this_for_practise.ui.theme.MobileApps_TESTING_CODES_USE_THIS_FOR_PRACTISETheme

class ReflectionPage : ComponentActivity() {

    //Variables created
    private lateinit var button: Button
    private lateinit var imageView: ImageView

    //Creating request code for image
    companion object{
        val IMAGE_REQUEST_CODE = 100
    }
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.reflection_page)
        overrideActivityTransition( OVERRIDE_TRANSITION_OPEN, R.anim.slide_in_right, R.anim.slide_out_left)

        //Creating variables for the buttons and text box
        val editText = findViewById<EditText>(R.id.reflectionPageTextbox)
        val awfulButton = findViewById<Button>(R.id.awfulButton)
        val sadButton = findViewById<Button>(R.id.sadButton)
        val okayButton = findViewById<Button>(R.id.okayButton)
        val happyButton = findViewById<Button>(R.id.happyButton)
        val awesomeButton = findViewById<Button>(R.id.awesomeButton)

        button = findViewById(R.id.btn_pick_img)
        imageView = findViewById(R.id.img_save)

        //Set up function for button to choose from image Library
        button.setOnClickListener {
            pickImageGallery()
        }


        //Change background based on what button is selected
        val bgcolorsaved = bgValue.bgColourChange

        val colorBg = findViewById<ConstraintLayout>(R.id.expand_on_feelings_colour)
        colorBg.setBackgroundColor(Color.parseColor(bgcolorsaved))

        //Set up buttons to change the background of the page
        awfulButton.setOnClickListener {
            bgValue.bgColourChange = "#4C2899"
            colorBg.setBackgroundColor(Color.parseColor("#4C2899"))
        }
        sadButton.setOnClickListener {
            bgValue.bgColourChange = "#6A77F0"
            colorBg.setBackgroundColor(Color.parseColor("#6A77F0"))
        }
        okayButton.setOnClickListener {
            bgValue.bgColourChange = "F49B55"
            colorBg.setBackgroundColor(Color.parseColor("#F49B55"))
        }
        happyButton.setOnClickListener {
            bgValue.bgColourChange = "#FFB800"
            colorBg.setBackgroundColor(Color.parseColor("#FFB800"))
        }
        awesomeButton.setOnClickListener {
            bgValue.bgColourChange = "#4CB543"
            colorBg.setBackgroundColor(Color.parseColor("#4CB543"))
        }

        Log.d("expand", "color check: $bgcolorsaved")

        //Creating button to save and go to the homepage
        val goToHomePage = findViewById<Button>(R.id.saveButton)
        goToHomePage.setOnClickListener {
            val intent = Intent(this, HomePage::class.java)
            startActivity(intent)
        }

        //Creating button to cancel and go to the homepage
        val goToHomePage2 = findViewById<Button>(R.id.cancelButton)
        goToHomePage2.setOnClickListener {
            val intent = Intent(this, HomePage::class.java)
            startActivity(intent)
        }
    }

    //function to select image from users phone
    private fun pickImageGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_REQUEST_CODE)
    }

    //function for requesting image and displaying in the page
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == IMAGE_REQUEST_CODE && resultCode == RESULT_OK ){
            imageView.setImageURI(data?.data)
        }
    }
}