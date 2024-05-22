package com.example.islami

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class hadeth_adapter(var mutableList: MutableList<hadeth_data>): RecyclerView.Adapter<hadeth_adapter.view_holder>() {
    class view_holder(item: View) : RecyclerView.ViewHolder(item){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): view_holder {

        val view =LayoutInflater.from(parent.context).inflate(R.layout.hadeth_item , parent , false)

return view_holder(view)   }

    override fun getItemCount(): Int =
mutableList.size

    var objectOnclick  : setOnClikeManuel?=null

    fun interface setOnClikeManuel{
      fun onClicked(position : Int ,item : hadeth_data )
    }



    override fun onBindViewHolder(holder: view_holder, position: Int) {
        val item = mutableList[position]
        holder.itemView.findViewById<TextView>(R.id.hadeth_text).text = item.title?:"nothing"

        objectOnclick.let {
            holder.itemView.setOnClickListener {
                objectOnclick?.onClicked( position, item)
            }

        }
    }
}