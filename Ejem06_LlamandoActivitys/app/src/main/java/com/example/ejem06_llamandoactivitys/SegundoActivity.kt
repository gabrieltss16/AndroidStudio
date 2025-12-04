package com.example.ejem06_llamandoactivitys

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejem06_llamandoactivitys.databinding.ActivitySegundoBinding

class SegundoActivity : AppCompatActivity() {

    lateinit var binding: ActivitySegundoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivitySegundoBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //val datoRecibido= intent.getStringExtra("DATO")
        val datoRecibido:Usuario= intent.getParcelableExtra("DATO",Usuario::class.java)!!
        //binding.tvDatoRecibido.text=datoRecibido



        binding.bDevolver.setOnClickListener {
            val datoDevolver=binding.tietDatoDevuelto.text.toString()
            Log.d("depurando","Dato a devolver: $datoDevolver")

            intent.putExtra("dato_devuelto",datoDevolver)
            setResult(RESULT_OK,intent)
            finish()
        }




    }
}