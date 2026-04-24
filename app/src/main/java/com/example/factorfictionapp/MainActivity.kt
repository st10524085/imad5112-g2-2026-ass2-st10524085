package com.example.factorfictionapp

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.txtView)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //textviews
        val lblHeadingHome= findViewById<TextView>(R.id.lblHeadingHome)
        val txtWelcome = findViewById<TextView>(R.id.txtWelcome)

        //Button
        val btnStart =findViewById<TextView>(R.id.btnStart)


        btnStart.setOnClickListener {
            //Navigate to the QuizActivityScreen
            val goToQuizActivity = Intent( this, QuizActivity::class.java)
            startActivity(goToQuizActivity)
        }
    }
}
/*
      Refrence List.
       The Independent Institute of Education(IIE),2026.Introduction to Mobile Application Development
       [IMAD5112 Module Manual] 2026. [Accessed 20 April 2026]

       Schools .,n.d Kotlin Booleans[online]
       Avaliable at:https://www.w3schools.com/kotlin/kotlin_booleans.php>
       [Accessed 20April 2026]*/