package com.example.islami.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.R
import com.example.islami.databinding.FragmentHadethBinding
import com.example.islami.hadeth_adapter
import com.example.islami.hadeth_data
import com.example.islami.hadeth_inside

class HadethFragment : Fragment() {
    lateinit var hadethAdapter: hadeth_adapter
lateinit var Frag_binding : FragmentHadethBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hadeth, container, false)
    }

    private fun readhadethfile() {
        val list = mutableListOf<hadeth_data>()

        val inputStream = context?.assets?.open("ahadeeth.txt")
        val fileContent = inputStream?.bufferedReader().use { it?.readText() }
        val allahadeeth = fileContent?.trim()?.split("#")
        allahadeeth?.forEach {hadeth ->
            val lines = hadeth.trim().split("\n")
            var Title = lines[0].trim()
            var newlist = lines.toMutableList().apply {
                removeAt(0)
            }
            val content = newlist.joinToString { "\n" }
            // cause this is list of string not string
            val Hadeth_class = hadeth_data(title = Title , content)
            list.add(Hadeth_class)
        }
        showHadethList(list)
    }

    private fun showHadethList(list: MutableList<hadeth_data>) {
        Frag_binding= FragmentHadethBinding.inflate(layoutInflater)
        hadethAdapter= hadeth_adapter(list)


        val rv = view?.findViewById<RecyclerView>(R.id.rv_hadeeth)
        rv?.adapter=hadethAdapter

            hadethAdapter.objectOnclick= hadeth_adapter.setOnClikeManuel { position, item ->
                var i = Intent(view?.context, hadeth_inside::class.java)
                val inputStream = context?.assets?.open("ahadeeth.txt")
                val fileContent = inputStream?.bufferedReader().use { it?.readText() }
                val allahadeeth = fileContent?.trim()?.split("#")
                i.putExtra("name" , allahadeeth!![position])
                startActivity(i)
            }

        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        readhadethfile()
    }
}