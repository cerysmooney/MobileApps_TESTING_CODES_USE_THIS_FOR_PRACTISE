package com.example.mobileapps_testing_codes_use_this_for_practise
import android.content.Intent
import android.graphics.Color
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.constraintlayout.widget.ConstraintLayout

class SoundPage : ComponentActivity() {

    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var imageView: ImageView
    private val imageResources = listOf(R.drawable.dance1, R.drawable.dance2, R.drawable.dance3)
    private var currentIndex = 0
    private val handler = Handler()

    private val runnable = object : Runnable {
        override fun run() {
            // Change the background to the next image
            imageView.setBackgroundResource(imageResources[currentIndex])

            // Increment the index or reset to 0 if it reaches the end
            currentIndex = (currentIndex + 1) % imageResources.size

            // Schedule the next iteration after a delay (e.g., 1 second)
            handler.postDelayed(this, 500)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Transition for getting to the page
        window.requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
        overrideActivityTransition(
            OVERRIDE_TRANSITION_OPEN,
            R.anim.slide_in_right,
            R.anim.slide_out_left
        )

        // Connecting to Layout
        setContentView(R.layout.sound_page)

        // BG background
        val bgcolorsaved = BGValue.bgColourChange
        val checkcolor = findViewById<ConstraintLayout>(R.id.sound_page_layout)
        checkcolor.setBackgroundColor(Color.parseColor(bgcolorsaved))

        // Set Variable for the media player
        val currentMediaPlayer = MutableMediaPlayer()

        // Initialize MediaPlayer Happy
        val playButtonHappy = findViewById<ImageButton>(R.id.playSoundHappy)

        playButtonHappy.setOnClickListener {
            // Change Background Colour
            checkcolor.setBackgroundColor(Color.parseColor("#4CB543"))
            stopMediaPlayer(currentMediaPlayer)
            playSound(R.raw.happy_noise, currentMediaPlayer)
        }

        // Initialize MediaPlayer Okay
        val playButtonOkay = findViewById<ImageButton>(R.id.playSoundOkay)

        playButtonOkay.setOnClickListener {
            // Change Background Colour
            checkcolor.setBackgroundColor(Color.parseColor("#F49B55"))
            stopMediaPlayer(currentMediaPlayer)
            playSound(R.raw.okay_noise, currentMediaPlayer)
        }

        // Initialize MediaPlayer Sad
        val playButtonSad = findViewById<ImageButton>(R.id.playSoundSad)

        playButtonSad.setOnClickListener {
            // Change Background Colour
            checkcolor.setBackgroundColor(Color.parseColor("#4C2899"))
            stopMediaPlayer(currentMediaPlayer)
            playSound(R.raw.anxious_noise, currentMediaPlayer)
        }

        // Creating the Stop Button to stop playing the media player
        val stopButton = findViewById<Button>(R.id.stopButton)

        stopButton.setOnClickListener {
            stopMediaPlayer(currentMediaPlayer)
        }

        val backButton = findViewById<Button>(R.id.cancelButton)
        backButton.setOnClickListener {
            val homePageScreen = Intent(this, HomePage::class.java)
            startActivity(homePageScreen)
            stopMediaPlayer(currentMediaPlayer)
        }

        imageView = findViewById(R.id.imageView)

        // Start the loop immediately
        handler.post(runnable)

        // Navigation Bar

        // Button for getting to the home page
        val soundHomePageButton = findViewById<ImageButton>(R.id.homePageButtonNav)
        soundHomePageButton.setOnClickListener {
            val homePageScreen = Intent(this, HomePage::class.java)
            startActivity(homePageScreen)
            stopMediaPlayer(currentMediaPlayer)
        }

        // Button for getting goals page
        val soundGoalsPageButton = findViewById<ImageButton>(R.id.goalsPageButtonNav)
        soundGoalsPageButton.setOnClickListener {
            val goalsPageScreen = Intent(this, GoalsPage::class.java)
            startActivity(goalsPageScreen)
            stopMediaPlayer(currentMediaPlayer)
        }
    }

    // When App is closed, music stops playing
    override fun onDestroy() {
        super.onDestroy()
        // Release the MediaPlayer when the activity is destroyed
        mediaPlayer.release()

        // Remove the callback to prevent memory leaks when the activity is destroyed
        handler.removeCallbacks(runnable)
    }

    private fun playSound(resourceId: Int, mediaPlayer: MutableMediaPlayer) {
        mediaPlayer.mediaPlayer?.let {
            if (it.isPlaying) {
                it.stop()
            }
        }
        mediaPlayer.mediaPlayer = MediaPlayer.create(this, resourceId)
        mediaPlayer.mediaPlayer?.start()
    }

    private fun stopMediaPlayer(mediaPlayer: MutableMediaPlayer) {
        mediaPlayer.mediaPlayer?.let {
            if (it.isPlaying) {
                it.stop()
            }
        }
    }

    //Having the media be able to be muted
    private class MutableMediaPlayer {
        var mediaPlayer: MediaPlayer? = null
    }
}