package com.example.mobileapps_testing_codes_use_this_for_practise

import android.media.MediaPlayer
import android.os.Bundle
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
import com.example.mobileapps_testing_codes_use_this_for_practise.ui.theme.MobileApps_TESTING_CODES_USE_THIS_FOR_PRACTISETheme

class SoundPage : ComponentActivity() {


    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sound_page)

        // Initialize MediaPlayer



        val playButton = findViewById<ImageButton>(R.id.playSound)

        playButton.setOnClickListener {

            val mediaPlayer = MediaPlayer.create(this, R.raw.birds)

            // Check if the audio is playing
            if (mediaPlayer.isPlaying) {
                // If playing, pause and update button text
                mediaPlayer.pause()
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

