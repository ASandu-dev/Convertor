package com.sandu.convertor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.view.isVisible
import com.sandu.convertor.fragments.DistanceFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val distanceFragment = DistanceFragment()
        val btnDistance : Button = findViewById(R.id.distanceBtn)


        btnDistance.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentPlace, distanceFragment)
                commit()
            }
            btnDistance.isVisible = false
        }


    }
}