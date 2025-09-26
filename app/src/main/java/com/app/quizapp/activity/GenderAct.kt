package com.app.quizapp.activity

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.app.quizapp.R
import com.app.quizapp.activity.HeightScreen.Companion.storeValue
import com.app.quizapp.activity.HeightScreen.Companion.unitStore
import com.app.quizapp.databinding.ActivityGenderBinding
import com.app.quizapp.util.moveAct
import com.app.quizapp.util.moveActNotFinish
import com.google.android.material.card.MaterialCardView

class GenderAct : AppCompatActivity() {
    private lateinit var binding: ActivityGenderBinding
    var gender = "male"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGenderBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Share PreF GET OR iNITIALIZE
        val pref = getSharedPreferences("DbRef", MODE_PRIVATE)

        // Create editor
        val editor = pref.edit()

        binding.apply {
            maleCard.setOnClickListener {

                genderCard(maleCard, femaleCard, male, female)

                gender = "male"
            }

            femaleCard.setOnClickListener {

                genderCard(femaleCard, maleCard, female, male)
                gender = "female"

            }

            nextBtn.setOnClickListener {
                // Value set or Save in SharePreference
                editor.putString("gender", gender)
                //Apply Changes or save
                editor.apply()
                moveActNotFinish(this@GenderAct, HeightScreen::class.java)
            }
        }
    }

    fun genderCard(
        activeCard: MaterialCardView, inactiveCard: MaterialCardView,
        activeText: TextView, inactiveText: TextView
    ) {
        activeCard.setCardBackgroundColor(getResources().getColor(R.color.common_color))
        inactiveCard.setCardBackgroundColor(getResources().getColor(R.color.card_color))
        activeText.setTextColor(getResources().getColor(R.color.white))
        inactiveText.setTextColor(getResources().getColor(R.color.common__light_color))
    }
}