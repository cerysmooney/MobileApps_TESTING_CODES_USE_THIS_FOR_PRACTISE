package com.example.mobileapps_testing_codes_use_this_for_practise

import android.content.Intent
import android.graphics.Color
import android.media.MediaPlayer
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.ComponentActivity
import androidx.constraintlayout.widget.ConstraintLayout

class SoundPage : ComponentActivity() {

    private lateinit var mediaPlayer: MediaPlayer
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
        setContentView(R.layout.sound_page)

        //BG background
        val bgcolorsaved = bgValue.bgColourChange
        val checkcolor = findViewById<ConstraintLayout>(R.id.sound_page_layout)
        checkcolor.setBackgroundColor(Color.parseColor(bgcolorsaved))

        //Set Variable for the media player
        var currentMediaPlayer: MediaPlayer? = null

        //Initialize MediaPlayer Happy
        val playButtonHappy = findViewById<ImageButton>(R.id.playSoundHappy)

        playButtonHappy.setOnClickListener {

            //Change Background Colour
            bgValue.bgColourChange = "#4CB543"
            checkcolor.setBackgroundColor(Color.parseColor("#4CB543"))

            //Check to see if the media player is currently in use, stop playing if true
            currentMediaPlayer?.let {
                if (it.isPlaying) {
                    it.stop()
                }
            }
            //Play happy noise
            val mediaPlayer = MediaPlayer.create(this, R.raw.happy_noise)
            currentMediaPlayer = mediaPlayer
            mediaPlayer.start()

        }

        // Initialize MediaPlayer Okay
        val playButtonOkay = findViewById<ImageButton>(R.id.playSoundOkay)

        playButtonOkay.setOnClickListener {

            //Change Background Colour
            bgValue.bgColourChange = "#F49B55"
            checkcolor.setBackgroundColor(Color.parseColor("#F49B55"))

            //Check to see if the media player is currently in use, stop playing if true
            currentMediaPlayer?.let {
                if (it.isPlaying) {
                    it.stop()
                }
            }
            //Play okay noise
            val mediaPlayer = MediaPlayer.create(this, R.raw.okay_noise)
            currentMediaPlayer = mediaPlayer
            mediaPlayer.start()

        }

        //Initialize MediaPlayer Awful
        val playButtonSad = findViewById<ImageButton>(R.id.playSoundSad)

        playButtonSad.setOnClickListener {

            //Change Background Colour
            bgValue.bgColourChange = "#4C2899"
            checkcolor.setBackgroundColor(Color.parseColor("#4C2899"))

            //Check to see if the media player is currently in use, stop playing if true
            currentMediaPlayer?.let {
                if (it.isPlaying) {
                    it.stop()
                }
            }
            //Play anxious noise
            val mediaPlayer = MediaPlayer.create(this, R.raw.anxious_noise)
            currentMediaPlayer = mediaPlayer
            mediaPlayer.start()

        }


        //Creating the Stop Button to stop playing the media player
        val stopButton = findViewById<Button>(R.id.stopButton)

        stopButton.setOnClickListener {

            //Check to see if the media player is currently in use, stop playing if true
            currentMediaPlayer?.let {
                if (it.isPlaying) {
                    it.stop()
                }
            }
        }

        val backToHomePageButton = findViewById<ImageButton>(R.id.reflectionPageButton2)
       backToHomePageButton.setOnClickListener {
            val Intent = Intent(this, HomePage::class.java)
            startActivity(Intent)
        }
    }



//When App is closed, music stops playing
    override fun onDestroy() {
        super.onDestroy()
        // Release the MediaPlayer when the activity is destroyed
        mediaPlayer.release()
    }
}

