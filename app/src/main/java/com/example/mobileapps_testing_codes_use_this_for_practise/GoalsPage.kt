package com.example.mobileapps_testing_codes_use_this_for_practise

import android.content.DialogInterface
import android.os.Bundle
import android.graphics.Color
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileapps_testing_codes_use_this_for_practise.Adapter.ToDoAdapter
import com.example.mobileapps_testing_codes_use_this_for_practise.Model.ToDoModel
import com.example.mobileapps_testing_codes_use_this_for_practise.Utils.DatabaseHandler
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlin.collections.ArrayList

class GoalsPage : AppCompatActivity(), DialogCloseListener {

    private lateinit var db: DatabaseHandler
    private lateinit var tasksRecyclerView: RecyclerView
    private lateinit var tasksAdapter: ToDoAdapter
    private lateinit var fab: FloatingActionButton
    private var taskList: List<ToDoModel> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.goals_page)
        supportActionBar?.hide()

        //BG background
        val bgcolorsaved = bgValue.bgColourChange
        val checkcolor = findViewById<RelativeLayout>(R.id.goalsPageLayout)
        checkcolor.setBackgroundColor(Color.parseColor(bgcolorsaved))

        db = DatabaseHandler(this)
        db.openDatabase()

        tasksRecyclerView = findViewById(R.id.tasksRecyclerView)
        tasksRecyclerView.layoutManager = LinearLayoutManager(this)
        tasksAdapter = ToDoAdapter(db, this, this)
        tasksRecyclerView.adapter = tasksAdapter

        val itemTouchHelper = ItemTouchHelper(RecyclerItemTouchHelper(tasksAdapter))
        itemTouchHelper.attachToRecyclerView(tasksRecyclerView)

        fab = findViewById(R.id.fab)
        taskList = db.getAllTasks()
        taskList = taskList.reversed()

        tasksAdapter.setTasks(taskList)

        fab.setOnClickListener {
            AddNewTask.newInstance().show(supportFragmentManager, AddNewTask.TAG)
        }
    }

    override fun handleDialogClose(dialog: DialogInterface) {
        taskList = db.getAllTasks()
        taskList = taskList.reversed()
        tasksAdapter.setTasks(taskList)
        tasksAdapter.notifyDataSetChanged()
    }
}
