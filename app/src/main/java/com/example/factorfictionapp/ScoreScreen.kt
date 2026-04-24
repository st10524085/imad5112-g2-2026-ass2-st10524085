package com.example.factorfictionapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ScoreScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_score_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val lblHeadingScore = findViewById<TextView>(R.id.lblHeadingScore)
        val lblFinalScore = findViewById<TextView>(R.id.lblFinalScore)
        val lblMemoScore = findViewById<TextView>(R.id.lblMemoScore)
        val btnMemo = findViewById<Button>(R.id.btnMemo)
        val btnHomeScreen = findViewById<Button>(R.id.btnHomeScreen)
        val btnExit = findViewById<Button>(R.id.btnExit)

        val finalScore = intent.getIntExtra("userScore", 0)


        val userPoints = intent.getIntExtra("User_Score", +1)
        val totalQuestions = 5

        lblFinalScore.text = "Final Score: $userPoints"
        btnMemo.setOnClickListener {
            lblMemoScore.text = """
           " 1. False!! Modern phones stop charging at 100% to prevent damage"
           "2.False!! Carrots help your eye health but won't fix your bad vision."
           "3.Fact. The alcohol in it dissolves ink before washing."
           "4.False!!.They heat from the outside in"
           "5.Fact. it keeps the dirt off your clothes for free."
           """.trimIndent()

        }





        //Display final score
        lblFinalScore.text = "Score: + $userPoints "



        btnHomeScreen.setOnClickListener {
                val homeScreen = Intent(this, MainActivity::class.java)
                startActivity(homeScreen)

        }
         //Exit quiz
        btnExit.setOnClickListener {
            finishAffinity()
        }

    }
}
/*
      Refrence List.
       The Independent Institute of Education(IIE),2026.Introduction to Mobile Application Development
       [IMAD5112 Module Manual] 2026. [Accessed 20 April 2026]

       Schools .,n.d Kotlin Booleans[online]
       Avaliable at:https://www.w3schools.com/kotlin/kotlin_booleans.php>
       [Accessed 20 April2026]*/