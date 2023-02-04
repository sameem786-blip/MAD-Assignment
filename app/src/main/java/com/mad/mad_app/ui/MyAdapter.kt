package com.mad.mad_app.ui

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.mad.mad_app.PersonActivity
import com.mad.mad_app.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch


class myAdapter(private val context : Context, val userData : List<record>,val viewType : Int) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val database by lazy { recordDatabase.getDatabase(context) }
    companion object {
        val VIEW_TYPE_ONE = 1
        val VIEW_TYPE_TWO = 2
    }

    class viewHolder(val itemview : View) : RecyclerView.ViewHolder(itemview){
        val name : TextView = itemview.findViewById(R.id.name)
        val description : TextView = itemview.findViewById(R.id.description)
        val favIcon : ImageView = itemView.findViewById(R.id.favIcon)
    }

    class viewHolder2(val itemview : View) : RecyclerView.ViewHolder(itemview){
        val name : TextView = itemview.findViewById(R.id.name)
        val description : TextView = itemview.findViewById(R.id.description)
    }


    override fun onCreateViewHolder(parent: ViewGroup, position: Int): RecyclerView.ViewHolder {

        if(viewType == VIEW_TYPE_ONE){
            return viewHolder(LayoutInflater.from(context).inflate(R.layout.list_item, parent, false))
        }
        return viewHolder2(LayoutInflater.from(context).inflate(R.layout.list_item2,parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(viewType === VIEW_TYPE_ONE){
            (holder as viewHolder).name.text = userData[position].name
            holder.description.text = userData[position].description
            if(userData[position].isFav){
                holder.favIcon.setImageResource(R.drawable.ic_baseline_favorite_border_24)
            }
            else {
                holder.favIcon.setImageResource(R.drawable.ic_baseline_favorite_24)
            }

            holder.favIcon.setOnClickListener {
                if(userData[position].isFav){
                    holder.favIcon.setImageResource(R.drawable.ic_baseline_favorite_24)
                    userData[position].isFav = false
                    CoroutineScope(Dispatchers.IO).launch {
                        database.record_dao().update(userData[position])
                    }
                }
                else if(!userData[position].isFav){
                    holder.favIcon.setImageResource(R.drawable.ic_baseline_favorite_border_24)
                    userData[position].isFav = true
                    CoroutineScope(Dispatchers.IO).launch {
                        database.record_dao().update(userData[position])
                    }
                }
            }

            (holder as viewHolder).itemView.setOnClickListener{
                val intent = Intent((holder as viewHolder).itemView.context,PersonActivity::class.java)
                intent.putExtra("name",userData[position].name)
                intent.putExtra("Profession",userData[position].description)
                holder.itemView.context.startActivity(intent)
            }
        }
        else if(viewType === VIEW_TYPE_TWO){
            (holder as viewHolder2).name.text = userData[position].name
            holder.description.text = userData[position].description

            holder.itemView.setOnClickListener {
                val intent =
                    Intent((holder as viewHolder2).itemView.context, PersonActivity::class.java)
                intent.putExtra("name", userData[position].name)
                intent.putExtra("Profession", userData[position].description)
                holder.itemView.context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int {
        return userData.size
    }
}