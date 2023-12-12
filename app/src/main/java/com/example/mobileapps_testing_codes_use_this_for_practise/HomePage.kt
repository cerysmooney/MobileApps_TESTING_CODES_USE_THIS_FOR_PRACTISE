package com.example.mobileapps_testing_codes_use_this_for_practise

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.constraintlayout.widget.ConstraintLayout
import java.text.SimpleDateFormat
import java.util.Date


class HomePage : ComponentActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private val CROSS1_KEY = "cross1_key"
    private val CROSS2_KEY = "cross2_key"
    private val CROSS3_KEY = "cross3_key"

    // Declare boolean variables to track the state of each button
    private var isCross1Checked = false
    private var isCross2Checked = false
    private var isCross3Checked = false

    @OptIn(ExperimentalMaterial3Api::class)    // ask luke about
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


        // Initialize SharedPreferences
        sharedPreferences = getPreferences(Context.MODE_PRIVATE)

        // Calling values for the image buttons to allow for changing background
        val imageCross = findViewById<ImageButton>(R.id.imageCross)
        val imageCross2 = findViewById<ImageButton>(R.id.imageCross2)
        val imageCross3 = findViewById<ImageButton>(R.id.imageCross3)

        // Retrieve the saved state for each button
        isCross1Checked = sharedPreferences.getBoolean(CROSS1_KEY, false)
        isCross2Checked = sharedPreferences.getBoolean(CROSS2_KEY, false)
        isCross3Checked = sharedPreferences.getBoolean(CROSS3_KEY, false)

        // Set the initial background state for each button
        updateButtonState(imageCross, isCross1Checked)
        updateButtonState(imageCross2, isCross2Checked)
        updateButtonState(imageCross3, isCross3Checked)

        // Changing the background on click for each button
        imageCross.setOnClickListener {
            isCross1Checked = !isCross1Checked
            updateButtonState(imageCross, isCross1Checked)
            saveState(CROSS1_KEY, isCross1Checked)
        }

        imageCross2.setOnClickListener {
            isCross2Checked = !isCross2Checked
            updateButtonState(imageCross2, isCross2Checked)
            saveState(CROSS2_KEY, isCross2Checked)
        }

        imageCross3.setOnClickListener {
            isCross3Checked = !isCross3Checked
            updateButtonState(imageCross3, isCross3Checked)
            saveState(CROSS3_KEY, isCross3Checked)
        }


        // Button for getting goals page
        val goalsPageButton = findViewById<ImageButton>(R.id.goalsPageButton)
        goalsPageButton.setOnClickListener {
            val goalsPageArrowButton = Intent(this, GoalsPage::class.java)
            startActivity(goalsPageArrowButton)
        }

        //Displaying hello and the name chosen from the name page
        //val name = intent.getStringExtra("textSave")
        //Log.d("HomePage", "name: $name")
        val callName = NameValue.nameData
        Log.d("HomePage", "callName: $callName")
        findViewById<TextView>(R.id.intro).apply {
            text = "Hello " + callName
        }

        //Log.d("HomePage","name: $callName")


        //Button for Expanding on Feelings
        val expandOnFeelingsPageButton = findViewById<ImageButton>(R.id.imagePlusIcon)
        expandOnFeelingsPageButton.setOnClickListener {
//            val fade: Transition = TransitionInflater.from(this).inflateTransition(R.transition.fade_transition)
//            fade.duration = 5000
//            window.exitTransition = fade
            val intent = Intent(this, ExpandOnFeelingsPage::class.java)
            startActivity(intent)
        }


        //NAVIGATION BAR

        //Button for getting to the sounds page
        val homeSoundPageButton = findViewById<ImageButton>(R.id.soundPageButtonNav)
        homeSoundPageButton.setOnClickListener {
            val soundPageScreen = Intent(this, SoundPage::class.java)
            startActivity(soundPageScreen)
        }

        // Button for getting goals page
        val homeGoalsPageButton = findViewById<ImageButton>(R.id.goalsPageButtonNav)
        homeGoalsPageButton.setOnClickListener {
            val goalsPageScreen = Intent(this, GoalsPage::class.java)
            startActivity(goalsPageScreen)
        }


    }

    //Updating the function of the button
    private fun updateButtonState(imageButton: ImageButton, isChecked: Boolean) {
        if (isChecked) {
            imageButton.setBackgroundResource(R.drawable.check)
        } else {
            imageButton.setBackgroundResource(R.drawable.cross)
        }
    }

        private fun saveState(key: String, value: Boolean) {
            sharedPreferences.edit().putBoolean(key, value).apply()
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




