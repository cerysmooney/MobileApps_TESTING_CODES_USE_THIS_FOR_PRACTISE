package com.example.mobileapps_testing_codes_use_this_for_practise

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.activity.ComponentActivity
import androidx.constraintlayout.widget.ConstraintLayout

class GPData1 {
    companion object {
        var goalsData1: String = ""
    }
}

class GPData2 {
    companion object {
        var goalsData2: String = ""
    }
}

class GPData3 {
    companion object {
        var goalsData3: String = ""
    }
}

class GPData4 {
    companion object {
        var goalsData4: String = ""
    }
}
class GoalsPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Transition
        //Transition for getting to the page
        window.requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
        overrideActivityTransition(
            OVERRIDE_TRANSITION_OPEN,
            R.anim.slide_in_right,
            R.anim.slide_out_left
        )

        //Connecting to Layout
        setContentView(R.layout.goals_page)

        //Goals Text
        val goal1 = findViewById<EditText>(R.id.typeYourGoal1)
        val goal2 = findViewById<EditText>(R.id.typeYourGoal2)
        val goal3 = findViewById<EditText>(R.id.typeYourGoal3)
        val goal4 = findViewById<EditText>(R.id.typeYourGoal4)

        val setGoal1 = GPData1.goalsData1
        findViewById<EditText>(R.id.typeYourGoal1).apply {
            setText(setGoal1)
        }

        val setGoal2 = GPData2.goalsData2
        findViewById<EditText>(R.id.typeYourGoal2).apply {
            setText(setGoal2)
        }

        val setGoal3 = GPData3.goalsData3
        findViewById<EditText>(R.id.typeYourGoal3).apply {
            setText(setGoal3)
        }

        val setGoal4 = GPData4.goalsData4
        findViewById<EditText>(R.id.typeYourGoal4).apply {
            setText(setGoal4)
        }

        //BG background
        val bgcolorsaved = BGValue.bgColourChange
        val checkcolor = findViewById<ConstraintLayout>(R.id.goals_page_layout)
        checkcolor.setBackgroundColor(Color.parseColor(bgcolorsaved))


        // Nav button to go to homepage
        val toHomePageButton = findViewById<ImageButton>(R.id.homePageButtonNav)
        toHomePageButton.setOnClickListener {
            val homePageScreen = Intent(this, HomePage::class.java)
            startActivity(homePageScreen)
        }

        // Nav button to go to SoundPage
        val toSoundPageButton = findViewById<ImageButton>(R.id.soundPageButtonNav)
        toSoundPageButton.setOnClickListener {
            val soundPageScreen = Intent(this, SoundPage::class.java)
            startActivity(soundPageScreen)
        }

        // Cancel button to go back to homepage
        val backToHomeButton = findViewById<Button>(R.id.cancelButton)
        backToHomeButton.setOnClickListener {
            val toHomeButtonScreen = Intent(this, HomePage::class.java)
            startActivity(toHomeButtonScreen)
        }

        val savetoHomeButton = findViewById<Button>(R.id.saveButton)
        savetoHomeButton.setOnClickListener {

            GPData1.goalsData1 = goal1.text.toString()
            GPData2.goalsData2 = goal2.text.toString()
            GPData3.goalsData3 = goal3.text.toString()
            GPData4.goalsData4 = goal4.text.toString()


            val saveToHomePageScreen = Intent(this, HomePage::class.java)
            startActivity(saveToHomePageScreen)
        }
    }
}


