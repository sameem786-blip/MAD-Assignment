package com.mad.mad_app.ui.Search

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mad.mad_app.R

class searchAdapter(private val context : Context, val data : ArrayList<apiData>) :
    RecyclerView.Adapter<searchAdapter.viewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): viewHolder {
        return viewHolder(LayoutInflater.from(context).inflate(R.layout.list_item3,parent,false))
    }
    override fun getItemCount(): Int {
        return data.size
    }
    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.data1.text = data[position].var1
        holder.data2.text = data[position].var2
    }
    class viewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val data1 = itemView.findViewById<TextView>(R.id.data1)
        val data2 = itemView.findViewById<TextView>(R.id.data2)
    }
}