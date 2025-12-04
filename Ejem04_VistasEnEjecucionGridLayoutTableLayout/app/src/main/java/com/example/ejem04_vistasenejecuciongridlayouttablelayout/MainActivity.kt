package com.example.ejem04_vistasenejecuciongridlayouttablelayout

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejem04_vistasenejecuciongridlayouttablelayout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var boton1: Button= Button(this)
        boton1.text="Boton creado en ejecucion"
        binding.llHorizontal.addView(boton1)




    }
}