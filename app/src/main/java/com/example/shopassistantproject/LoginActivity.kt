package com.example.shopassistantproject

import android.content.Intent
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.shopassistantproject.databinding.ActivityLoginBinding
import com.example.shopassistantproject.databinding.ActivityProductListBinding
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val auth = FirebaseAuth.getInstance()

//login
        binding.btlog1.setOnClickListener {
            auth.signInWithEmailAndPassword(txtlog1.text.toString(), txtlog2.text.toString())
                .addOnCompleteListener {
                    if (it.isSuccessful){
                        Toast.makeText(this, "Login Accepted", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this, MainActivity::class.java).also {
                            it.putExtra("user", auth.currentUser?.email)
                        })
                    }
                    else{
                        Toast.makeText(this, "Login Error", Toast.LENGTH_SHORT).show()
                    }
                }
        }
//register
        binding.btlog1.setOnLongClickListener {
            auth.createUserWithEmailAndPassword(txtlog1.text.toString(), txtlog2.text.toString())
                .addOnCompleteListener {
                    if (it.isSuccessful){
                        Toast.makeText(this, "Register Accepted", Toast.LENGTH_SHORT).show()
                    }
                    else{
                        Toast.makeText(this, "Register Error", Toast.LENGTH_SHORT).show()
                    }
                }
            true
        }
    }
}