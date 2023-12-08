package com.example.mobileapps_testing_codes_use_this_for_practise.ui.theme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mobileapps_testing_codes_use_this_for_practise.R
import com.example.mobileapps_testing_codes_use_this_for_practise.ui.theme.ui.theme.MobileApps_TESTING_CODES_USE_THIS_FOR_PRACTISETheme
import android.media.MediaPlayer
import android.view.View


class SoundPage : ComponentActivity() {

    var mMediaPlayer: MediaPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sound_page)



        // 1. Plays the water sound
        fun playSound() {
            if (mMediaPlayer == null) {
                mMediaPlayer = MediaPlayer.create(this, R.raw.birds)
                mMediaPlayer!!.isLooping = true
                mMediaPlayer!!.start()
            } else mMediaPlayer!!.start()
        }

        // 2. Pause playback
        fun pauseSound() {
            if (mMediaPlayer?.isPlaying == true) mMediaPlayer?.pause()
        }

        // 3. Stops playback
        fun stopSound() {
            if (mMediaPlayer != null) {
                mMediaPlayer!!.stop()
                mMediaPlayer!!.release()
                mMediaPlayer = null
            }
        }

        // 4. Destroys the MediaPlayer instance when the app is closed
//        fun onStop() {
//            super.onStop()
//            if (mMediaPlayer != null) {
//                mMediaPlayer!!.release()
//                mMediaPlayer = null
//            }
//        }

        setContent {
            MobileApps_TESTING_CODES_USE_THIS_FOR_PRACTISETheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MobileApps_TESTING_CODES_USE_THIS_FOR_PRACTISETheme {
        Greeting("Android")
    }
}