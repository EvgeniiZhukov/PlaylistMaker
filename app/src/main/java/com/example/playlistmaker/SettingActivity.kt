package com.example.playlistmaker

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        val buttonReturn = findViewById<Button>(R.id.buttonBack)
        val switchTheme = findViewById<Switch>(R.id.switchTheme)
        val buttonContactSupport = findViewById<Button>(R.id.buttonContactSupport)
        val buttonUserAgreement = findViewById<Button>(R.id.buttonUserAgreement)

        buttonReturn.setOnClickListener {
            this.finish()
        }

        switchTheme.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }

        buttonContactSupport.setOnClickListener{
            val eMail = "evgenyzhykov@yandex.ru"
            val theme = "Сообщение разработчикам и разработчицам приложения Playlist Maker"
            val message = "Спасибо разработчикам и разработчицам за крутое приложение!"
            val supportEmailIntent = Intent(Intent.ACTION_SEND)
                supportEmailIntent.data = Uri.parse("mailto:")
                supportEmailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(eMail))
                supportEmailIntent.putExtra(Intent.EXTRA_SUBJECT, theme)
                supportEmailIntent.putExtra(Intent.EXTRA_TEXT, message)
            startActivity(supportEmailIntent)
        }

        buttonUserAgreement.setOnClickListener{
            val webpage: Uri = Uri.parse("https://yandex.ru/legal/practicum_offer/")
            val intent = Intent(Intent.ACTION_VIEW, webpage)
            startActivity(intent)
        }

    }

}