package com.example.shopassistantproject

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.CompoundButton
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.shopassistantproject.databinding.ActivityOptionsBinding
import kotlinx.android.synthetic.main.activity_options.*


class OptionsActivity : AppCompatActivity() {

    private lateinit var sp: SharedPreferences
    //


    //editor


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //What exactly layoutinflater makes?
        val binding = ActivityOptionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sp = getSharedPreferences("shared", MODE_PRIVATE)
        val editor = sp.edit()

        binding.s1.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked == true) {
                editor.putBoolean("dark", true)
                AppCompatDelegate.setDefaultNightMode(2.toInt())

            } else {

                editor.putBoolean("dark", false)
                AppCompatDelegate.setDefaultNightMode(1.toInt())

            }
            editor.apply()
        }


        binding.s2.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked == true) {
                //zmienia letters
            } else {

            }

        }

    }

    override fun onStart() {
        super.onStart()
        val editor = sp.edit()

        if (sp.getBoolean("dark", true)) {
            s1.isChecked = true
            editor.putBoolean("dark", true)
            editor.apply()
        }

        else {

            s1.isChecked = false
            editor.putBoolean("dark", false)
                    editor.apply()
        }
        }





    override fun onStop() {
        super.onStop()
        val editor = sp.edit()
        if (s1.isChecked == true) {
            editor.putBoolean("dark", true)
            editor.apply()
        }
        else {
                editor.putBoolean("dark", false)
                editor.apply()
        }

    }


    }
