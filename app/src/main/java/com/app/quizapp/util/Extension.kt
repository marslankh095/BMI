package com.app.quizapp.util

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.TextView
import com.app.quizapp.R


fun moveAct(currentAct: Activity, targetAct:Class<*>){
    var intent= Intent(currentAct, targetAct)
    currentAct.startActivity(intent)
    //Current Activty Finish
    currentAct.finish()
    // Complete App Finish
    //currentAct.finishAffinity()
}

fun moveActNotFinish(currentAct: Activity, targetAct:Class<*>) {
    var intent= Intent(currentAct, targetAct)
    currentAct.startActivity(intent)

}

 fun changeUnitBg(context: Activity, kg: TextView, libs:TextView) {
    kg.setBackgroundResource(R.drawable.ftcm_fill_bg)
    libs.setBackgroundResource(R.drawable.ftcm_whilte_fill_bg)
    kg.setTextColor(context.getColor(R.color.white))
    libs.setTextColor(context.getColor(R.color.common__light_color))
}