package com.example.mobileapps_testing_codes_use_this_for_practise

import android.content.Intent
import android.content.res.Resources
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.media.Image
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.mobileapps_testing_codes_use_this_for_practise.ui.theme.MobileApps_TESTING_CODES_USE_THIS_FOR_PRACTISETheme
import java.text.SimpleDateFormat
import java.util.Date


class HomePage : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overrideActivityTransition(
            OVERRIDE_TRANSITION_OPEN,
            R.anim.slide_in_right,
            R.anim.slide_out_left
        )
        setContentView(R.layout.home_page)

        //BG background
        val bgcolorsaved = bgValue.bgColourChange
        val checkcolor = findViewById<ConstraintLayout>(R.id.homePageLayout)
        checkcolor.setBackgroundColor(Color.parseColor(bgcolorsaved))

        //Getting date and displaying in textview
        val textView: TextView = findViewById(R.id.dateAndTime)
        val simpleDateFormat = SimpleDateFormat("dd.MM.yyyy")
        val currentDateAndTime: String = simpleDateFormat.format(Date())
        textView.text = currentDateAndTime

        //Calling values for the image buttons to allow for changing background
//        val imageCross = findViewById<ImageButton>(R.id.imageCross)
//        val imageCross2 = findViewById<ImageButton>(R.id.imageCross2)
//        val imageCross3 = findViewById<ImageButton>(R.id.imageCross3)
//        val imageCross4 = findViewById<ImageButton>(R.id.goalsPageButton)

        //Changing the background on click for each button
//        imageCross.setOnClickListener{
//            imageCross.setBackgroundResource(R.drawable.check)
//        }
//        imageCross2.setOnClickListener{
//            imageCross2.setBackgroundResource(R.drawable.check)
//        }
//        imageCross3.setOnClickListener{
//            imageCross3.setBackgroundResource(R.drawable.check)
//        }
//        imageCross4.setOnClickListener{
//            imageCross4.setBackgroundResource(R.drawable.check)
//        }

        //Displaying hello and the name chosen from the name page
        //val name = intent.getStringExtra("textSave")
        //Log.d("HomePage", "name: $name")
        val callName = NameValue.nameData
        Log.d("HomePage", "callName: $callName")
        val introduction = findViewById<TextView>(R.id.intro).apply {
            text = "Hello " + callName
        }

        //Log.d("HomePage","name: $callName")

        //Button for getting to goals page
        val homeGoalsPageButton = findViewById<ImageButton>(R.id.reflectionPageButton)
        homeGoalsPageButton.setOnClickListener{
            val Intent = Intent(this,CalendarPage::class.java)
            startActivity(Intent)
        }

        //Button for Expanding on Feelings
        val expandOnFeelingsPageButton = findViewById<ImageButton>(R.id.imagePlusIcon)
        expandOnFeelingsPageButton.setOnClickListener {

            val intent = Intent(this, ExpandOnFeelingsPage::class.java)
            startActivity(intent)
        }


    }
}



//    @OptIn(ExperimentalMaterial3Api::class)
//    @Composable
//    fun ExpandableCard(){
//        val shapes = Shapes(
//            small = RoundedCornerShape(4.dp),
//            medium = RoundedCornerShape(4.dp),
//            large = RoundedCornerShape(0.dp)
//        )
//        var expandedState by remember { mutableStateOf(false) }
//
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//                .animateContentSize(
//                    animationSpec = tween(
//                        delayMillis = 300,
//                        easing = LinearOutSlowInEasing
//                    )
//                ),
//            shape = shapes.medium,
//            onClick = {
//                expandedState = !expandedState
//            }
//        ) {
//            Column(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(12.dp)
//            ) {
//                Text(
//                    text = "GOALS FOR THE DAY!",
//                    fontSize = MaterialTheme.typography.headlineMedium.fontSize,
//                    fontWeight = FontWeight.Bold,
//                    textAlign = TextAlign.Center
//                )
//            }
//        }
//    }
//    @ExperimentalMaterial3Api
//    @Composable
//    @Preview
//    fun ExpandableCardPreview(){
//        ExpandableCard()
//    }
//}




