package com.example.linkndial

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val enteredURL: EditText = findViewById(R.id.enterURL)
        val openButtonURL: Button = findViewById(R.id.buttonOpenURL)

        val enteredNumber: EditText = findViewById(R.id.enterNumber)
        val openButtonDial: Button = findViewById(R.id.buttonDial)

        openButtonURL.setOnClickListener{
            val openURL = Intent(Intent.ACTION_VIEW)
            val url = enteredURL.text.toString()
            if(url.isNotEmpty()){
                openURL.data = Uri.parse("https://$url")
                startActivity(openURL)
            }
            else{
                Toast.makeText(this, "Please enter a URL", Toast.LENGTH_LONG).show()
            }

        }

        openButtonDial.setOnClickListener{
            val num = enteredNumber.text.toString()
            if(num.isNotEmpty()){
                val callIntent = Intent(Intent.ACTION_DIAL)
                callIntent.data = Uri.parse("tel:$num")
                startActivity(callIntent)
            }
            else{
                Toast.makeText(this, "Please enter a number", Toast.LENGTH_LONG).show()
            }
        }
    }
}