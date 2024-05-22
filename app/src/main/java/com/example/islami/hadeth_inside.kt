package com.example.islami

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.islami.databinding.ActivityHadethBinding
import com.example.islami.databinding.ActivityHadethContentBinding

class hadeth_inside : AppCompatActivity() {
   lateinit var view  : ActivityHadethBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view = ActivityHadethBinding.inflate(layoutInflater)
        setContentView(view.root)

        val text = findViewById<TextView>(R.id.hadeth_varses)
        text.text= intent.getStringExtra("name")
        setSupportActionBar(view.toolbarId)
        setTitle(null)
        // to delete title from back button
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)


    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}