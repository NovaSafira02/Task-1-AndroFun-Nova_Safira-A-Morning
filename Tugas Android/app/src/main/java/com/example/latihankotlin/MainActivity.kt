package com.example.latihankotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.latihankotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var tv:TextView
    private lateinit var  binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        tv = findViewById(R.id.textView2)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnFragment0.setOnClickListener {replaceFragment(Fragment_One())}
        binding.btnFragment1.setOnClickListener { replaceFragment(Fragment_Two()) }



        val email = intent.getParcelableExtra<User>("User")?.email
        val password = intent.getParcelableExtra<User>("User")?.passwod
        tv.text = "Email: $email dan Password: $password"
        val btn_Share: Button = findViewById(R.id.btn_share)
        btn_Share.setOnClickListener(this)
   }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_share  ->{
//                val message = "Bagikan"
//                val intent = Intent()
//                intent.action = Intent.ACTION_SEND
//                intent.putExtra(Intent.EXTRA_TEXT, message)
//                intent.type = "text/plain"
//                startActivity(intent)
               val intent = Intent()
                intent.putExtra("riwayat","Sudah Penah Login")
                setResult(RESULT_OK, intent)
                finish()
            }
        }

    }
    private fun replaceFragment(fragment : Fragment){
        val fragmentManajer = supportFragmentManager
        val fragmentTransaction = fragmentManajer.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container_view_tag, fragment)
        fragmentTransaction.commit()
    }
}