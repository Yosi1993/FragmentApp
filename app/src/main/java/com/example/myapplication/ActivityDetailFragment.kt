package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ActivityDetailFragment : Fragment() {

    private val tasks = arrayOf("Tarea 1", "Tarea 2", "Tarea 3")

    companion object {
        private const val ARG_ACTIVITY_INDEX = "activity_index"

        fun newInstance(activityIndex: Int): ActivityDetailFragment {
            val fragment = ActivityDetailFragment()
            val args = Bundle()
            args.putInt(ARG_ACTIVITY_INDEX, activityIndex)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_activity_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val activityIndex = arguments?.getInt(ARG_ACTIVITY_INDEX) ?: 0

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = TaskAdapter(tasks) { position ->
            val intent = Intent(context, TaskDetailActivity::class.java)
            intent.putExtra("task_index", position)
            intent.putExtra("activity_index", activityIndex)
            startActivity(intent)
        }

        // Agregar divisores entre las tareas
        val dividerItemDecoration = DividerItemDecoration(recyclerView.context, (recyclerView.layoutManager as LinearLayoutManager).orientation)
        recyclerView.addItemDecoration(dividerItemDecoration)
    }
}
