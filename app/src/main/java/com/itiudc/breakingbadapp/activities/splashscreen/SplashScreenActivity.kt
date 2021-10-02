package com.itiudc.breakingbadapp.activities.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.itiudc.breakingbadapp.R
import com.itiudc.breakingbadapp.activities.loginscreen.LoginScreenActivity


class SplashScreenActivity : AppCompatActivity() {

    lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        handler = Handler()
        handler.postDelayed({
            val intent = Intent(this, LoginScreenActivity::class.java)
            startActivity(intent)
            finish()
        }, 4000) //Delay 3 seconds top open MainActivity
    }
}