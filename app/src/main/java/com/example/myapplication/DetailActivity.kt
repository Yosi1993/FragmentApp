package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        if (savedInstanceState == null) {
            val activityIndex = intent.getIntExtra("activity_index", 0)
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ActivityDetailFragment.newInstance(activityIndex))
                .commit()
        }
    }
}
