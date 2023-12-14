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
        val bgcolorsaved = BGValue.bgColourChange
        val checkcolor = findViewById<ConstraintLayout>(R.id.sound_page_layout)
        checkcolor.setBackgroundColor(Color.parseColor(bgcolorsaved))

        //Set Variable for the media player
        var currentMediaPlayer: MediaPlayer? = null

        //Initialize MediaPlayer Happy
        val playButtonHappy = findViewById<ImageButton>(R.id.playSoundHappy)

        playButtonHappy.setOnClickListener {

            //Change Background Colour
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

        val backButton = findViewById<Button>(R.id.cancelButton)
        backButton.setOnClickListener {
            val homePageScreen = Intent(this, HomePage::class.java)
            startActivity(homePageScreen)

            currentMediaPlayer?.let {
                if (it.isPlaying) {
                    it.stop()
                }
            }
        }


        //NAVIGATION BAR

        //Button for getting to the home page
        val soundHomePageButton = findViewById<ImageButton>(R.id.homePageButtonNav)
        soundHomePageButton.setOnClickListener {
            val homePageScreen = Intent(this,HomePage::class.java)
            startActivity(homePageScreen)

            currentMediaPlayer?.let {
                if (it.isPlaying) {
                    it.stop()
                }
            }
        }

        // Button for getting goals page
        val soundGoalsPageButton = findViewById<ImageButton>(R.id.goalsPageButtonNav)
        soundGoalsPageButton.setOnClickListener {
            val goalsPageScreen = Intent(this,GoalsPage::class.java)
            startActivity(goalsPageScreen)

            currentMediaPlayer?.let {
                if (it.isPlaying) {
                    it.stop()
                }
            }
        }


    }



//When App is closed, music stops playing
    override fun onDestroy() {
        super.onDestroy()
        // Release the MediaPlayer when the activity is destroyed
        mediaPlayer.release()
    }
}

