package com.itiudc.breakingbadapp.activities.loginscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.itiudc.breakingbadapp.R
import com.itiudc.breakingbadapp.activities.mainscreen.MainActivity


class LoginScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)

        val inputEmail      = findViewById<EditText>(R.id.input_email)
        val inputPassword   = findViewById<EditText>(R.id.input_password)
        val buttonLogin        = findViewById<Button>(R.id.button_login)

        buttonLogin.setOnClickListener(){
            //Validations
            when{
                inputEmail.text.isEmpty() && inputPassword.text.isEmpty() -> Toast.makeText(this, "${R.string.login_unwritten_both}", Toast.LENGTH_SHORT).show()
                inputEmail.text.isEmpty() -> Toast.makeText(this, "${R.string.login_unwritten_email}", Toast.LENGTH_SHORT).show()
                inputPassword.text.isEmpty() -> Toast.makeText(this, "${R.string.login_unwritten_password}", Toast.LENGTH_SHORT).show()
                !android.util.Patterns.EMAIL_ADDRESS.matcher(inputEmail.text).matches() -> Toast.makeText(this, "${R.string.login_error_email}", Toast.LENGTH_SHORT).show()
                inputPassword.text.length < 5 -> Toast.makeText(this, "${R.string.login_error_password}", Toast.LENGTH_SHORT).show()
                else ->{
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
            }
        }

    }
}