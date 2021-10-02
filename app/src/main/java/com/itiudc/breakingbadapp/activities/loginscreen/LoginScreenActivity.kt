package com.itiudc.breakingbadapp.activities.loginscreen

import android.content.Intent
import android.content.res.Resources
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

        val stringResource: Resources = resources

        val inputEmail      = findViewById<EditText>(R.id.input_email)
        val inputPassword   = findViewById<EditText>(R.id.input_password)
        val buttonLogin        = findViewById<Button>(R.id.button_login)

        val unwrittenBoth: String =  stringResource.getString(R.string.login_unwritten_both)
        val unwrittenEmail: String = stringResource.getString(R.string.login_unwritten_email)
        val unwrittenPassword: String = stringResource.getString(R.string.login_unwritten_password)
        val errorEmail: String = stringResource.getString(R.string.login_error_email)
        val errorPassword: String = stringResource.getString(R.string.login_error_password)

        buttonLogin.setOnClickListener(){
            //Validations
            when{
                inputEmail.text.isEmpty() && inputPassword.text.isEmpty() ->
                    Toast.makeText(this, unwrittenBoth, Toast.LENGTH_SHORT).show()
                inputEmail.text.isEmpty() ->
                    Toast.makeText(this, unwrittenEmail, Toast.LENGTH_SHORT).show()
                inputPassword.text.isEmpty() ->
                    Toast.makeText(this, unwrittenPassword, Toast.LENGTH_SHORT).show()
                !android.util.Patterns.EMAIL_ADDRESS.matcher(inputEmail.text).matches() ->
                    Toast.makeText(this, errorEmail, Toast.LENGTH_SHORT).show()
                inputPassword.text.length < 5 ->
                    Toast.makeText(this, errorPassword, Toast.LENGTH_SHORT).show()
                else ->{
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}