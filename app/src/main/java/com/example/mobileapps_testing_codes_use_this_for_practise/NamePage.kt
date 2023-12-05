package com.example.mobileapps_testing_codes_use_this_for_practise


import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.constraintlayout.widget.ConstraintLayout

class NameValue {
    companion object {
        var nameData: String = ""
    }
}

class NamePage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overrideActivityTransition( OVERRIDE_TRANSITION_OPEN, R.anim.slide_in_right, R.anim.slide_out_left)
        setContentView(R.layout.name_page)

        //val bgcolorsaved = intent.getStringExtra("saveBackground")
        val bgcolorsaved = bgValue.bgColourChange
        val editText = findViewById<EditText>(R.id.enterName)
        val checkcolor = findViewById<ConstraintLayout>(R.id.namePageLayout)

       // Log.d(TAG, checkcolor)

       checkcolor.setBackgroundColor(Color.parseColor(bgcolorsaved))

//        if (bgcolorsaved != null) {
//
//        }


        val calendarPageButton = findViewById<Button>(R.id.nameButton)
        calendarPageButton.setOnClickListener {
            NameValue.nameData = editText.text.toString()
            val setName = NameValue.nameData

            Log.d("NamePage", "setName: $setName")
            //val name = editText.text.toString()
            //Log.d("NamePage", "name:$name")

            val Intent = Intent(this, HomePage::class.java).also{
                //it.putExtra("textSave",name)
                startActivity(it)
            }

        }
    }
}
