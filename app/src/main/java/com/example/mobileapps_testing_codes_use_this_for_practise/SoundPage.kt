package com.example.mobileapps_testing_codes_use_this_for_practise

import android.graphics.Color
import android.media.MediaPlayer
import android.os.Bundle
import android.view.Window
import android.widget.ImageButton
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

        setContentView(R.layout.sound_page)

        //BG background
        val bgcolorsaved = bgValue.bgColourChange
        val checkcolor = findViewById<ConstraintLayout>(R.id.sound_page_layout)
        checkcolor.setBackgroundColor(Color.parseColor(bgcolorsaved))



        // Initialize MediaPlayer Happy
        val playButtonHappy = findViewById<ImageButton>(R.id.playSoundHappy)

        playButtonHappy.setOnClickListener {

            val mediaPlayer = MediaPlayer.create(this, R.raw.birds)

            // Check if the audio is playing
            if (mediaPlayer.isPlaying) {
                // If playing, pause and update button text
                mediaPlayer.stop()
//                playButton.text = "Play Audio"
            } else {
                // If not playing, start playing and update button text
                mediaPlayer.start()
//                playButton.text = "Pause Audio"
            }
        }

        // Initialize MediaPlayer Okay
        val playButtonOkay = findViewById<ImageButton>(R.id.playSoundOkay)

        playButtonOkay.setOnClickListener {

            val mediaPlayer = MediaPlayer.create(this, R.raw.birds)

            // Check if the audio is playing
            if (mediaPlayer.isPlaying) {
                // If playing, pause and update button text
                mediaPlayer.stop()
//                playButton.text = "Play Audio"
            } else {
                // If not playing, start playing and update button text
                mediaPlayer.start()
//                playButton.text = "Pause Audio"
            }
        }

        // Initialize MediaPlayer Awful
        val playButtonSad = findViewById<ImageButton>(R.id.playSoundSad)

        playButtonSad.setOnClickListener {

            val mediaPlayer = MediaPlayer.create(this, R.raw.birds)

            // Check if the audio is playing
            if (mediaPlayer.isPlaying) {
                // If playing, pause and update button text
                mediaPlayer.stop()
//                playButton.text = "Play Audio"
            } else {
                // If not playing, start playing and update button text
                mediaPlayer.start()
//                playButton.text = "Pause Audio"
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        // Release the MediaPlayer when the activity is destroyed
        mediaPlayer.release()
    }
}

