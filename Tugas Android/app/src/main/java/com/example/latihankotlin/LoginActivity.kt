package com.example.latihankotlin

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var riwayat:TextView

    val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data: Intent? = result.data
            val returnString: String? = data?.getStringExtra("riwayat")
            riwayat.text = returnString
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        riwayat =findViewById(R.id.riwayat)
        etEmail = findViewById(R.id.edt_email)
        etPassword = findViewById(R.id.edt_Password)

        val bundle = intent.extras
        if (bundle != null){
            etEmail.setText(bundle.getString("email"))
            etPassword.setText((bundle.getString("password")))
        }

        val btnLogin: Button = findViewById(R.id.btn_login)
        btnLogin.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_login -> {
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                intent.putExtra("User", User(etEmail.text.toString(), etPassword.text.toString()))
                resultLauncher.launch(intent)
            }
        }
    }
}