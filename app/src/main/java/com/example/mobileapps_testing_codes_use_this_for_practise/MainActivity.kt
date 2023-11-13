package com.example.mobileapps_testing_codes_use_this_for_practise

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.mobileapps_testing_codes_use_this_for_practise.ui.theme.MobileApps_TESTING_CODES_USE_THIS_FOR_PRACTISETheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.my_layout)

        val seek = findViewById<SeekBar>(R.id.seekBar2)
        val awful = findViewById<TextView>(R.id.awful_emotion); findViewById<ImageView>(R.id.awful_owl)
        val sad = findViewById<TextView>(R.id.sad_emotion); findViewById<ImageView>(R.id.sad_owl)
        val okay = findViewById<TextView>(R.id.ok_emotion); findViewById<ImageView>(R.id.ok_owl)
        val happy = findViewById<TextView>(R.id.happy_emotion); findViewById<ImageView>(R.id.happy_owl)
        val awesome = findViewById<TextView>(R.id.awesome_emotion); findViewById<ImageView>(R.id.awesome_owl)
        seek.setMax(4)
        seek.setProgress(2)

        seek?.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seek: SeekBar, progress: Int, fromUser: Boolean){
                if (progress == 0){
                    awful.setVisibility(View.VISIBLE)
                    sad.setVisibility(View.INVISIBLE)
                    okay.setVisibility(View.INVISIBLE)
                    happy.setVisibility(View.INVISIBLE)
                    awesome.setVisibility(View.INVISIBLE)
                }
                else if (progress == 1){
                    awful.setVisibility(View.INVISIBLE)
                    sad.setVisibility(View.VISIBLE)
                    okay.setVisibility(View.INVISIBLE)
                    happy.setVisibility(View.INVISIBLE)
                    awesome.setVisibility(View.INVISIBLE)
                }
                else if (progress == 2){
                    awful.setVisibility(View.INVISIBLE)
                    sad.setVisibility(View.INVISIBLE)
                    okay.setVisibility(View.VISIBLE)
                    happy.setVisibility(View.INVISIBLE)
                    awesome.setVisibility(View.INVISIBLE)
                }
                else if (progress == 3){
                    awful.setVisibility(View.INVISIBLE)
                    sad.setVisibility(View.INVISIBLE)
                    okay.setVisibility(View.INVISIBLE)
                    happy.setVisibility(View.VISIBLE)
                    awesome.setVisibility(View.INVISIBLE)
                }
                else if (progress == 4){
                    awful.setVisibility(View.INVISIBLE)
                    sad.setVisibility(View.INVISIBLE)
                    okay.setVisibility(View.INVISIBLE)
                    happy.setVisibility(View.INVISIBLE)
                    awesome.setVisibility(View.VISIBLE)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                TODO("Not yet implemented")
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                TODO("Not yet implemented")
            }
        })

        val namePageButton = findViewById<Button>(R.id.button)
        namePageButton.setOnClickListener{
            val Intent = Intent(this,NamePage::class.java)
            startActivity(Intent)
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Surface (color = Color.Cyan){
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    MobileApps_TESTING_CODES_USE_THIS_FOR_PRACTISETheme {
        Greeting("peepee")
    }
}