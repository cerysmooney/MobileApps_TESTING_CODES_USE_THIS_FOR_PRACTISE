package com.example.mobileapps_testing_codes_use_this_for_practise

import android.graphics.Color
import android.media.MediaPlayer
import android.os.Bundle
import android.view.Window
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

        setContentView(R.layout.sound_page)

        //BG background
        val bgcolorsaved = bgValue.bgColourChange
        val checkcolor = findViewById<ConstraintLayout>(R.id.sound_page_layout)
        checkcolor.setBackgroundColor(Color.parseColor(bgcolorsaved))



        var currentMediaPlayer: MediaPlayer? = null

        // Initialize MediaPlayer Happy
        val playButtonHappy = findViewById<ImageButton>(R.id.playSoundHappy)

        playButtonHappy.setOnClickListener {

            // val mediaPlayer = MediaPlayer.create(this, R.raw.birds)

            currentMediaPlayer?.let{
                if(it.isPlaying) {
                    it.stop()
                }
            }

            val mediaPlayer = MediaPlayer.create(this, R.raw.happy_noise)

            currentMediaPlayer = mediaPlayer

            mediaPlayer.start()

//            // Check if the audio is playing
//            if (mediaPlayer.isPlaying) {
//                // If playing, pause and update button text
//                mediaPlayer.stop()
////                playButton.text = "Play Audio"
//            } else {
//                // If not playing, start playing and update button text
//                mediaPlayer.start()
////                playButton.text = "Pause Audio"
//            }
        }


        // Initialize MediaPlayer Okay
        val playButtonOkay = findViewById<ImageButton>(R.id.playSoundOkay)

        playButtonOkay.setOnClickListener {

//            val mediaPlayer = MediaPlayer.create(this, R.raw.okay_noise)
                currentMediaPlayer?.let {
                    if(it.isPlaying) {
                        it.stop()
                    }
                }
            val mediaPlayer = MediaPlayer.create(this, R.raw.okay_noise)
            currentMediaPlayer = mediaPlayer
            mediaPlayer.start()

//            // Check if the audio is playing
//            if (mediaPlayer.isPlaying) {
//                // If playing, pause and update button text
//                mediaPlayer.stop()
////                playButton.text = "Play Audio"
//            } else {
//                // If not playing, start playing and update button text
//                mediaPlayer.start()
////                playButton.text = "Pause Audio"
//            }
        }

        // Initialize MediaPlayer Awful
        val playButtonSad = findViewById<ImageButton>(R.id.playSoundSad)

        playButtonSad.setOnClickListener {

//            val mediaPlayer = MediaPlayer.create(this, R.raw.anxious_noise)

            currentMediaPlayer?.let {
                if (it.isPlaying) {
                    it.stop()
                }
            }

            val mediaPlayer = MediaPlayer.create(this, R.raw.anxious_noise)
            currentMediaPlayer = mediaPlayer
            mediaPlayer.start()

        }
//            // Check if the audio is playing
//            if (mediaPlayer.isPlaying) {
//                // If playing, pause and update button text
//                mediaPlayer.stop()
////                playButton.text = "Play Audio"
//            } else {
//                // If not playing, start playing and update button text
//                mediaPlayer.start()
////                playButton.text = "Pause Audio"
//            }
//        }
    }

    override fun onDestroy() {
        super.onDestroy()
        // Release the MediaPlayer when the activity is destroyed
        mediaPlayer.release()
    }
}

