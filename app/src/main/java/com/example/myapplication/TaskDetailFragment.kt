package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class TaskDetailFragment : Fragment() {

    companion object {
        private const val ARG_TASK_INDEX = "task_index"
        private const val ARG_ACTIVITY_INDEX = "activity_index"

        fun newInstance(taskIndex: Int, activityIndex: Int): TaskDetailFragment {
            val fragment = TaskDetailFragment()
            val args = Bundle()
            args.putInt(ARG_TASK_INDEX, taskIndex)
            args.putInt(ARG_ACTIVITY_INDEX, activityIndex)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_task_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val taskIndex = arguments?.getInt(ARG_TASK_INDEX) ?: 0
        val activityIndex = arguments?.getInt(ARG_ACTIVITY_INDEX) ?: 0

        val taskTitle: TextView = view.findViewById(R.id.taskTitle)
        val taskDescription: TextView = view.findViewById(R.id.taskDescription)

        taskTitle.text = "Detalles de la tarea ${taskIndex + 1}"
        taskDescription.text = "Esta es la información detallada sobre la tarea ${taskIndex + 1} de la actividad ${activityIndex + 1}. Aquí puedes agregar más información relevante sobre la tarea, incluyendo instrucciones, notas y cualquier otro detalle importante que desees mostrar."
    }
}
