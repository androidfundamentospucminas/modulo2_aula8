package com.walker.modulo2aula8androidfundamentos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

const val SECOND_ACTIVITY_PARAMETER = "SECOND_ACTIVITY_PARAMETER"

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        intent?.extras?.getString(MAIN_ACTIVITY_PARAMETER)?.let {
            findViewById<TextView>(R.id.originText).text = it
        }

        findViewById<Button>(R.id.buttonOpenMainActivity).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(SECOND_ACTIVITY_PARAMETER, "Aberto pela SecondActivity")
            startActivity(intent)
        }

    }
}