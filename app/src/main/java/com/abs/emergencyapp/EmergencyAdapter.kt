package com.abs.emergencyapp

import android.app.Activity
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView

class EmergencyAdapter(val activity: Activity, val emergencies: List<Emergency>) :
    RecyclerView.Adapter<EmergencyAdapter.MVH>() {

    class MVH(v: View) : RecyclerView.ViewHolder(v) {
        val parent: CardView = v.findViewById(R.id.parent)
        val iv: ImageView = v.findViewById(R.id.image)
        val tv: TextView = v.findViewById(R.id.tv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MVH {
        val view = activity.layoutInflater
            .inflate(R.layout.emergency_list_item, parent, false)
        return MVH(view)
    }

    override fun onBindViewHolder(holder: MVH, position: Int) {
        holder.iv.setImageResource(emergencies[position].pic)
        holder.tv.text = emergencies[position].name
        holder.parent.setOnClickListener {
            val i = Intent(Intent.ACTION_DIAL, "tel:${emergencies[position].number}".toUri())
            activity.startActivity(i)
        }
    }

    override fun getItemCount() = emergencies.size


}