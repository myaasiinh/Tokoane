package com.tokoane.ui.activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textview.MaterialTextView
import com.tokoane.R

class LoginActivity : AppCompatActivity(R.layout.login_auth) {

    private var password: TextInputEditText? = null
    private var email: TextInputEditText? = null
    private lateinit var loginBtn: ImageButton
    private lateinit var  sharedPreferences: SharedPreferences

    companion object{
        fun start(context: Context) {
            val intent = Intent(context, LoginActivity::class.java)
            context.startActivity(intent)
        }
    }

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val registerButton = findViewById<MaterialTextView>(R.id.daftar_disiniTv)
        registerButton.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        email = findViewById(R.id.email_loginEt)
        password = findViewById(R.id.password_loginEt)
        loginBtn = findViewById(R.id.login_btnTv)

    }

    override fun onStart() {
        super.onStart()
        checkForLogin()

    }

    private fun checkForLogin() {
        sharedPreferences = getSharedPreferences("USER_CREDENTIALS", MODE_PRIVATE)
        val isloggedin = sharedPreferences.getBoolean("ISLOGGEDIN", false)
        val requiredEmail = sharedPreferences.getString("EMAIL", "DEFAULT_EMAIL")
        val requiredPassword = sharedPreferences.getString("PASSWORD", "DEFAULT_PASSWORD")
        loginBtn.setOnClickListener {
            if (isloggedin) {
                validate(requiredEmail, requiredPassword)
            } else {
                Toast.makeText(this,
                    "Silahkan buat akun dahulu",
                    Toast.LENGTH_LONG).show()

            }
        }

    }

    private fun validate(requiredEmail: String?, requiredPassword: String?) {
        val emailIn = email?.text.toString()
        val passwordIn = password?.text.toString()
        if (!TextUtils.isEmpty(emailIn) && !TextUtils.isEmpty(passwordIn)) {
            if (emailIn.contains("@")) {
                isEmailLogin(emailIn, passwordIn, requiredEmail, requiredPassword)
            } else {
                Toast.makeText(this,
                    "Email keliru atau salah",
                    Toast.LENGTH_LONG).show()
            }
        } else {
            Toast.makeText(
                this,
                "Harap cek kolom pengisian",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    private fun isEmailLogin(
        email: String,
        password: String,
        required_email: String?,
        required_password: String?
    ) {
        if (email == required_email && password == required_password) {
            sharedPreferences.edit().putBoolean("ISLOGGEDIN", true).apply()
            Toast.makeText(this,
                "Masuk akun berhasil",
                Toast.LENGTH_SHORT).show()
            startMainActivity()

        } else {
            Toast.makeText(this,
                "Katasandi keliru atau salah",
                Toast.LENGTH_LONG).show()
        }

    }

    private fun startMainActivity() {
        MainActivity.start(this@LoginActivity)
        /*
        startProfil()

         */
        finish()

    }
 /*
    fun startProfil()  {
        ProfilActivity.start(this@Login)
        finish()

    }

  */

}