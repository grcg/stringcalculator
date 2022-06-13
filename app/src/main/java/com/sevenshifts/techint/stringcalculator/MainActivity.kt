package com.sevenshifts.techint.stringcalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val cal = Calculator()
        println("Addition result:: ${cal.add("9,7\n,-2,3\n,2,-1,5")}")
    }
}