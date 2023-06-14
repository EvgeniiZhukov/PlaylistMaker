package com.example.playlistmaker

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        val buttonReturn = findViewById<Button>(R.id.button1)
        buttonReturn.setOnClickListener {
            val returnIntent = Intent(this, MainActivity::class.java)
            startActivity(returnIntent)
        }
    }

}