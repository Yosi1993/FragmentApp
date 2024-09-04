package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ActivityAdapter(
    private val activities: Array<String>,
    private val onActivityClick: (Int) -> Unit
) : RecyclerView.Adapter<ActivityAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Inflar el nuevo layout personalizado para los ítems
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Establecer el texto del TextView con el nombre de la actividad
        holder.activityName.text = activities[position]

        // Configurar el listener para el clic en el ítem
        holder.itemView.setOnClickListener { onActivityClick(position) }
    }

    override fun getItemCount() = activities.size

    // ViewHolder que se encarga de vincular las vistas del layout de ítem
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val activityName: TextView = itemView.findViewById(R.id.activityName)
    }
}
