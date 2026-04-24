package com.example.factorfictionapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class QuizActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //textviews
        val lblHeadingQuiz = findViewById<TextView>(R.id.lblHeadingQuiz)
        val lblQuestionQuiz= findViewById<TextView>(R.id.lblQuestionQuiz)
        val lblFeedbackQuiz = findViewById<TextView>(R.id.lblFeedbackQuiz)

        //Buttons
        val btnStartQuiz = findViewById<Button>(R.id.btnStartQuiz)
        val btnResult= findViewById<Button>(R.id.btnResult)
        val btnFact = findViewById<Button>(R.id.btnFact)
        val btnFalse = findViewById<Button>(R.id.btnFalse)


        val question1 = "1.Charging your phone overnight ruins the battery"
        val answer1 = false
        val question2 = "2.Eating carrots drastically improves your eyesight"
        val answer2 = false
        val question3 = "3.Hairspray removes ink stains from your clothes"
        val answer3 = true
        val question4 = "4.Microwaves cook food from the inside out"
        val answer4 = false
        val question5 = "5.A shower cap keeps shoes separate in your luggage"   
        val answer5 = true

        var userScore = 0

        btnResult.setOnClickListener {
            val resultsScreen = Intent(this, ScoreScreen::class.java)
            resultsScreen.putExtra("userScore", userScore)
            startActivity(resultsScreen)

        }

        var currentQuestion = 1

        btnFact.isEnabled = false
        btnFalse.isEnabled = false

        btnStartQuiz.setOnClickListener {

            userScore = 0 //score starts at zero

            currentQuestion = 1
            lblQuestionQuiz.text = question1
            btnFact.isEnabled = true
            btnFalse.isEnabled = true
        }

        btnFact.setOnClickListener {

            for (question in 1..5) {
                if (question == currentQuestion) {

                    if (question == 1 || question == 2 || question == 4) {

                        userScore++
                        lblFeedbackQuiz.text = "Correct!That's real time-saver Score: $userScore"
                    } else{
                        lblFeedbackQuiz.text = "Wrong!Thats just an urban myth. Score: $userScore"

                    }

                    break
                }

            }

            currentQuestion++

            when (currentQuestion) {
                2 -> lblQuestionQuiz.text = question2
                3 -> lblQuestionQuiz.text = question3
                4 -> lblQuestionQuiz.text = question4
                5 -> lblQuestionQuiz.text =question5
                else -> {
                    lblQuestionQuiz.text = "Quiz Completed!"
                    lblFeedbackQuiz.text = "Final Score: ${userScore}"
                    btnFact.isEnabled = false
                    btnFalse.isEnabled = false
                }
            }
        }

        btnFalse.setOnClickListener {

            for (question in 1..5) {

                if (question == currentQuestion) {

                    if (question == 3|| question == 5) {
                        userScore++
                        lblFeedbackQuiz.text = "Correct!That's real time-saver Score: $userScore"
                    } else {
                        lblFeedbackQuiz.text = "Wrong!Thats just an urban myth. Score: $userScore"


                    }

                    break
                }


            }

            currentQuestion++

            when (currentQuestion) {
                2 -> lblQuestionQuiz .text =question2
                3 -> lblQuestionQuiz.text = question3
                4 -> lblQuestionQuiz.text =question4
                5 -> lblQuestionQuiz.text = question5
                else -> {
                    lblQuestionQuiz.text = "Quiz Completed!"
                    lblFeedbackQuiz.text = "Final Score: ${userScore}"
                    btnFact.isEnabled = false
                    btnFalse.isEnabled = false
                }
            }
        }

    }
}
/*
      Refrence List.
       The Independent Institute of Education(IIE),2026.Introduction to Mobile Application Development
       [IMAD5112 Module Manual] 2026. [Accessed 20 April 2026]

       Schools .,n.d Kotlin Booleans[online]
       Avaliable at:https://www.w3schools.com/kotlin/kotlin_booleans.php>
       [Accessed 20 April 2026]*/



