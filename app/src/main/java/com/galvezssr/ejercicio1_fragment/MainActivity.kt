package com.galvezssr.ejercicio1_fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.galvezssr.ejercicio1_fragment.databinding.ActivityMainBinding

/* TODO COMIENZA EN EL MAIN */
class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}