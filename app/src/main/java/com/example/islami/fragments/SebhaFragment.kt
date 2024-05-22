package com.example.islami.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.islami.R

class SebhaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sebha, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var counter = 1
        var btn = view.findViewById<Button>(R.id.sebha_btn)
        btn.setOnClickListener {
            val text = view.findViewById<TextView>(R.id.counter_sebha)

            text.text = counter.toString()
            view.findViewById<ImageView>(R.id.body_sebha).animate().rotationBy(10.909090909091f).duration=10
            counter++
            if (counter==34){
                if (counter+1==35 && btn.text == "سبحان الله"){
                    btn.text = "الحمد الله"
                }else if (btn.text == "الحمد الله"){
                    btn.text =  "الله اكبر"
                }else if(btn.text == "الله اكبر"){
                    btn.text = "سبحان الله"
                }
                counter=0
            }
        }

    }
}