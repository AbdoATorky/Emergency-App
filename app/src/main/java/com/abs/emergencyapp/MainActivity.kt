package com.abs.emergencyapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val emergencies =listOf(
            //ctrl + p
            Emergency(
                R.drawable.fire,
                "Fire Truck",
                "180",
            ),
            Emergency(
                R.drawable.child_care,
                "Child Rescue",
                "16000",
            ),
            Emergency(
                R.drawable.police,
                "Police",
                "122",
            )
        )

    }
}