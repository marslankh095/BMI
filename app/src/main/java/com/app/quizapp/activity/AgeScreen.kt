package com.app.quizapp.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.app.quizapp.R
import com.app.quizapp.activity.HeightScreen.Companion.storeValue
import com.app.quizapp.databinding.ActivityAgeScreenBinding
import com.app.quizapp.util.moveActNotFinish

class AgeScreen : AppCompatActivity() {
    private lateinit var binding: ActivityAgeScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityAgeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val pref = getSharedPreferences("DbRef", MODE_PRIVATE)
        // Create editor
        val editor = pref.edit()


        binding.apply {

            scale.setStartingPoint(25f)
            ageValue.text="25"
            scale.setUpdateListener { result ->
                ageValue.text = "%.0f".format(result)
                storeValue=ageValue.text.toString().toFloat()

            }

            backIcon.setOnClickListener {
                finish()
            }

            nextBtn.setOnClickListener {it->
                editor.putInt("ageValue",ageValue.text.toString().toInt())
                editor.apply()
                moveActNotFinish(this@AgeScreen, Dashboard::class.java)
            }


        }



    }
}