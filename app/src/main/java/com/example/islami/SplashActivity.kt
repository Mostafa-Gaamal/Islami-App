package com.example.islami

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.islami.databinding.ActivitySplachBinding

@Suppress("DEPRECATION")
class SplashActivity : AppCompatActivity() {
    lateinit var viewBind : ActivitySplachBinding
    lateinit var handler : Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBind =ActivitySplachBinding.inflate(layoutInflater)
        setContentView(viewBind.root)

        Handler().postDelayed({
      val i = Intent(this,MainActivity::class.java)
            startActivity(i)
            finish()

        }, 2000)


    }
}