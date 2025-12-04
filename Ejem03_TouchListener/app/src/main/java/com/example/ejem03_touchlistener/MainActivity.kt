package com.example.ejem03_touchlistener

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejem03_touchlistener.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.llFondo.setOnTouchListener{ vista,evento ->
            Log.d("depurando","Has tocado el fondo de la pantalla")

            true
        }

        binding.llFrontal.setOnTouchListener{ vista,evento ->
            Log.d("depurando","Has tocado la parte frontal de la pantalla")

            false
        }

    }
}