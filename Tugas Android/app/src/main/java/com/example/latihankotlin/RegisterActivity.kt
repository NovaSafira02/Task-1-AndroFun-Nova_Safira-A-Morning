package com.example.latihankotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class RegisterActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var etNama_lengkap : EditText
    private lateinit var etNomor_telepon : EditText
    private lateinit var etEmail : EditText
    private lateinit var etPassword : EditText
    private lateinit var etComfirm_pswd : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        etNama_lengkap = findViewById(R.id.edt_nama_lengkap)
        etNomor_telepon = findViewById(R.id.edt_nomor_telepon)
        etEmail = findViewById(R.id.edt_email)
        etPassword = findViewById(R.id.edt_password)
        etComfirm_pswd = findViewById(R.id.edt_confirm_pswd)


        val btnRegister: Button = findViewById(R.id.btn_register)
        btnRegister.setOnClickListener(this)
    }

    override fun onClick(v: View) {
         when(v.id){
            R.id.btn_register -> {
                val bundle = Bundle()
                bundle.putString("nama_lengkap", etNama_lengkap.text.toString())
                bundle.putString("nomor_telepon",etNomor_telepon.text.toString())
                bundle.putString("email",etEmail.text.toString())
                bundle.putString("password",etPassword.text.toString())
                bundle.putString("confirm_pswd", etComfirm_pswd.text.toString())

                val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                intent.putExtras(bundle)
                startActivity(intent)
            }
        }
    }
}