package com.itiudc.breakingbadapp.activities.loginscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.itiudc.breakingbadapp.R
import com.itiudc.breakingbadapp.activities.mainscreen.MainActivity
import com.itiudc.breakingbadapp.databinding.ActivityLoginScreenBinding
import kotlin.contracts.Returns

class LoginScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)

        val binding: ActivityLoginScreenBinding = DataBindingUtil.setContentView<ActivityLoginScreenBinding>(this, R.layout.activity_login_screen)

        val inputEmail      = findViewById<EditText>(R.id.input_email)
        val inputPassword   = findViewById<EditText>(R.id.input_password)
        val buttonLogin        = findViewById<Button>(R.id.button_login)

        buttonLogin.setOnClickListener(){
            //Validations
            when{
                inputEmail.text.isEmpty() && inputPassword.text.isEmpty() -> Toast.makeText(this, "Please write something...", Toast.LENGTH_SHORT).show()
                inputEmail.text.isEmpty() -> Toast.makeText(this, "Please write your email", Toast.LENGTH_SHORT).show()
                inputPassword.text.isEmpty() -> Toast.makeText(this, "Please write your password", Toast.LENGTH_SHORT).show()
                !android.util.Patterns.EMAIL_ADDRESS.matcher(inputEmail.text).matches() -> Toast.makeText(this, "Please write a correct email", Toast.LENGTH_SHORT).show()
                inputPassword.text.length < 5 -> Toast.makeText(this, "Please enter a password greater than 5 characters", Toast.LENGTH_SHORT).show()
                else ->{
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
            }
        }

    }
}