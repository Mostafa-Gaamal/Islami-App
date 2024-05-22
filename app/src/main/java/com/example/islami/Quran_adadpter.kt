package com.example.islami

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.databinding.QuranItemBinding

class Quran_adadpter(var Quran_list : MutableList<String>, var ayat_list : MutableList<Int>) : RecyclerView.Adapter<Quran_adadpter.Quran_view_holder>() {

    public class Quran_view_holder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Quran_view_holder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.quran_item , parent , false)
        return Quran_view_holder(view)
    }

    override fun getItemCount(): Int = Quran_list.size



    override fun onBindViewHolder(holder: Quran_view_holder, position: Int) {
        var itemOne = Quran_list[position]
        var itemTwo = ayat_list[position]

        holder.itemView.findViewById<TextView>(R.id.surah_name).text = itemOne
        holder.itemView.findViewById<TextView>(R.id.atay_num).text = itemTwo.toString()

        if (setonClickObject != null){
            holder.itemView.setOnClickListener {
                setonClickObject?.onClick(Quran_list[position],position)
            }
            holder.itemView.setOnClickListener {
                setonClickObject?.onClick(ayat_list[position].toString(),position)
            }

        }



    }
   var setonClickObject : setClick? = null

    fun interface setClick{
         fun onClick(itemView:String , position: Int)
    }
}