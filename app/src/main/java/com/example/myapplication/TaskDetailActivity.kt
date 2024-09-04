package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class TaskDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_detail)

        if (savedInstanceState == null) {
            val taskIndex = intent.getIntExtra("task_index", 0)
            val activityIndex = intent.getIntExtra("activity_index", 0)
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, TaskDetailFragment.newInstance(taskIndex, activityIndex))
                .commit()
        }
    }
}
