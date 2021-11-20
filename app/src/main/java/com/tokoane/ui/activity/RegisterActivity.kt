package com.tokoane.ui.activity

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textview.MaterialTextView
import com.tokoane.R

class RegisterActivity : AppCompatActivity(R.layout.register_auth) {

    private var fullName: TextInputEditText? = null
    private var email: TextInputEditText? = null
    private var password: TextInputEditText? = null
    private var conFirmPassword: TextInputEditText? = null
    private lateinit var signUpBtn: ImageButton

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val loginButton = findViewById<MaterialTextView>(R.id.login_disiniTv)
        loginButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        fullName = findViewById(R.id.fullname_registerEt)
        email = findViewById(R.id.email_registerEt)
        password = findViewById(R.id.password_registerEt)
        conFirmPassword = findViewById(R.id.reconfirm_password_registerEt)
        signUpBtn = findViewById(R.id.create_accountTv)
        signUpBtn.setOnClickListener {
            validate()

        }

    }

    private fun validate() {
        val name = fullName!!.text.toString()
        val emailIn = email!!.text.toString()
        val passwordIn = password!!.text.toString()
        val rePassword = conFirmPassword!!.text.toString()
        if (!TextUtils.isEmpty(name) &&
            !TextUtils.isEmpty(emailIn) &&
            !TextUtils.isEmpty(passwordIn)
        ) {
            if (emailIn.contains("@")) {
                if (passwordIn == rePassword) {
                    startRegistration(name, emailIn, passwordIn)
                    startLoginActivity()
                    Toast.makeText(this,
                        "Akun berhasil dibuat",
                        Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this,
                        "password salah atau keliru",
                        Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(this,
                    "email kosong",
                    Toast.LENGTH_LONG).show()
            }
        } else {
            Toast.makeText(this,
                "cek kolom pengisian",
                Toast.LENGTH_LONG).show()
        }

    }

    private fun startRegistration(
        name: String,
        email_in: String,
        password_in: String) {
        val sharedPreferences = getSharedPreferences("USER_CREDENTIALS", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("NAME", name)
        editor.putString("EMAIL", email_in)
        editor.putString("PASSWORD", password_in)
        editor.putBoolean("ISLOGGEDIN", true)
        editor.apply()
    }

    private fun startLoginActivity() {
        LoginActivity.start(this@RegisterActivity)
    }
}