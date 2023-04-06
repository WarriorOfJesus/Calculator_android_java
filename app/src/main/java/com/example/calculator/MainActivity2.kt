package com.example.calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.calculator.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        with(binding) {
            setContentView(root)
            val text: String = calculator.getStory()
            story.text = text
            buttonClearStory.setOnClickListener {
                calculator.clearStory()
                val text: String = calculator.getStory()
                story.text = text
            }
        }
    }
}