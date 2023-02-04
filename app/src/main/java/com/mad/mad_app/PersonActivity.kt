package com.mad.mad_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mad.mad_app.databinding.ActivityPersonBinding

class PersonActivity : AppCompatActivity() {
    private lateinit var binding : ActivityPersonBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPersonBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.userInfo.text = intent.getStringExtra("name").toString() + "'s Profession = " + intent.getStringExtra("Profession").toString()

    }
}