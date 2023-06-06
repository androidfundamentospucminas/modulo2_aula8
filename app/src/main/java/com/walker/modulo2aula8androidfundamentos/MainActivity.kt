package com.walker.modulo2aula8androidfundamentos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

const val MAIN_ACTIVITY_PARAMETER = "MAIN_ACTIVITY_PARAMETER"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        intent.extras?.getString(SECOND_ACTIVITY_PARAMETER)?.let {
            findViewById<TextView>(R.id.originText).text = it
        }

        findViewById<Button>(R.id.buttonOpenSecondActivity).setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(MAIN_ACTIVITY_PARAMETER, "Aberto pela MainActivity")
            startActivity(intent)
        }

    }
}