package com.example.phone.viewcontrollers.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.phone.R
import com.example.phone.viewcontrollers.fragments.ListingFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState == null){
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.content_frame, ListingFragment.newInstance())
                .commit()
        }
    }
}