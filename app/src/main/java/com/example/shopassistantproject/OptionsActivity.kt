package com.example.shopassistantproject

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.shopassistantproject.databinding.ActivityMainBinding
import com.example.shopassistantproject.databinding.ActivityOptionsBinding
import com.example.shopassistantproject.databinding.ActivityProductListBinding
import kotlinx.android.synthetic.main.activity_options.*

var bigdata: Int = 20
var smalldata: Int = 14

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
        val bindingA = ActivityMainBinding.inflate(layoutInflater)
        val bindingP = ActivityProductListBinding.inflate(layoutInflater)

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
                editor.putBoolean("big", true)

                    txo1.textSize = bigdata.toFloat()
                    txo2.textSize = bigdata.toFloat()
                    s1.textSize = bigdata.toFloat()
                    s2.textSize = bigdata.toFloat()
                bindingA.bt1.textSize = bigdata.toFloat()
                bindingA.bt2.textSize = bigdata.toFloat()
                bindingA.tx1.textSize = bigdata.toFloat()

                bindingP.btl1.textSize = bigdata.toFloat()
                bindingP.ch1.textSize = bigdata.toFloat()
                bindingP.edl2.textSize = bigdata.toFloat()
                bindingP.edl1.textSize = bigdata.toFloat()

                }
            else {
                editor.putBoolean("big", false)
                    txo1.textSize = smalldata.toFloat()
                    txo2.textSize = smalldata.toFloat()
                    s1.textSize = smalldata.toFloat()
                    s2.textSize = smalldata.toFloat()
                bindingA.bt1.textSize = smalldata.toFloat()
                bindingA.bt2.textSize = smalldata.toFloat()
                bindingA.tx1.textSize = smalldata.toFloat()

                bindingP.btl1.textSize = smalldata.toFloat()
                bindingP.ch1.textSize = smalldata.toFloat()
                bindingP.edl2.textSize = smalldata.toFloat()
                bindingP.edl1.textSize = smalldata.toFloat()
                }

            }

        }



    override fun onStart() {
        super.onStart()
        val bindingA = ActivityMainBinding.inflate(layoutInflater)
        val bindingP = ActivityProductListBinding.inflate(layoutInflater)
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


        if (sp.getBoolean("big", true)) {
            s2.isChecked = true
            editor.putBoolean("big", true)

            txo1.textSize = bigdata.toFloat()
            txo2.textSize = bigdata.toFloat()
            s1.textSize = bigdata.toFloat()
            s2.textSize = bigdata.toFloat()
            bindingA.bt1.textSize = bigdata.toFloat()
            bindingA.bt2.textSize = bigdata.toFloat()
            bindingA.tx1.textSize = bigdata.toFloat()

            bindingP.btl1.textSize = bigdata.toFloat()
            bindingP.ch1.textSize = bigdata.toFloat()
            bindingP.edl2.textSize = bigdata.toFloat()
            bindingP.edl1.textSize = bigdata.toFloat()
            editor.apply()
        }
        else {
            s2.isChecked = false
            editor.putBoolean("big", false)

            txo1.textSize = smalldata.toFloat()
            txo2.textSize = smalldata.toFloat()
            s1.textSize = smalldata.toFloat()
            s2.textSize = smalldata.toFloat()
            bindingA.bt1.textSize = smalldata.toFloat()
            bindingA.bt2.textSize = smalldata.toFloat()
            bindingA.tx1.textSize = smalldata.toFloat()

            bindingP.btl1.textSize = smalldata.toFloat()
            bindingP.ch1.textSize = smalldata.toFloat()
            bindingP.edl2.textSize = smalldata.toFloat()
            bindingP.edl1.textSize = smalldata.toFloat()
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


        if (s2.isChecked == true) {
            editor.putBoolean("big", true)
            editor.apply()



        }
        else {
            editor.putBoolean("big", false)
            editor.apply()


        }


    }


    }
