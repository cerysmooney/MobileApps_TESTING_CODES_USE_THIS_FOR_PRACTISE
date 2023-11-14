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
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import com.example.mobileapps_testing_codes_use_this_for_practise.ui.theme.MobileApps_TESTING_CODES_USE_THIS_FOR_PRACTISETheme
import org.w3c.dom.Text

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.my_layout)

        val seek = findViewById<SeekBar>(R.id.seekBar2)
        val text = findViewById<TextView>(R.id.emotions)
        val owlIMG = findViewById<ImageView>(R.id.owl_images)

        seek?.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seek: SeekBar, progress: Int, fromUser: Boolean){
                when {
                    progress <= 0 -> text.text = "AWFUL"
                    progress <= 1 -> text.text = "SAD"
                    progress <= 2 -> text.text = "OKAY"
                    progress <= 3 -> text.text = "HAPPY"
                    else -> text.text = "AWESOME"
                }
                when {
                    progress <= 0 -> owlIMG.setImageResource(R.drawable.awful_owl)
                    progress <= 1 -> owlIMG.setImageResource(R.drawable.sadowl)
                    progress <= 2 -> owlIMG.setImageResource(R.drawable.okowl)
                    progress <= 3 -> owlIMG.setImageResource(R.drawable.happyowl)
                    else -> owlIMG.setImageResource(R.drawable.awesomeowl)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
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