package com.example.shopassistantproject

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.CompoundButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.shopassistantproject.databinding.ActivityOptionsBinding
import kotlinx.android.synthetic.main.activity_options.*


class OptionsActivity : AppCompatActivity() {

    private lateinit var sp: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //What exactly layoutinflater makes?
        val binding = ActivityOptionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sp = getPreferences(Context.MODE_PRIVATE)


    }
}