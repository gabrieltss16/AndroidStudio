package com.example.ejer05_ontouchlistener

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejer05_ontouchlistener.databinding.ActivityMainBinding

lateinit var binding : ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //var listaUsuarios = ArrayList<Usuario>()
        var listaUsuarios=mutableListOf<Usuario>()

        listaUsuarios.add(Usuario("Pepe","pepe123"))
        listaUsuarios.add(Usuario("Pedro","123456789"))
        listaUsuarios.add(Usuario("Pepito","password"))

        binding.spUsuarios.adapter = ArrayAdapter<Usuario>(this,android.R.layout.simple_list_item_1, listaUsuarios)

        var listener : (AdapterView.OnItemSelectedListener)= object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

                val miUsuario : Usuario= binding.spUsuarios.getItemAtPosition(p2) as Usuario
                Log.d("debug",miUsuario.nombre+" - "+miUsuario.password)
                binding.user = miUsuario
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }
        binding.spUsuarios.onItemSelectedListener = listener


        var lastUsuarioAdded = Usuario("","")
        binding.clAreaAzul.setOnTouchListener { view, motionEvent ->
            if (motionEvent.action.equals(MotionEvent.ACTION_MOVE)) {
                val miUsuario = Usuario(binding.tielNombre.text.toString(),
                                    binding.tielPassword.text.toString())
                if (lastUsuarioAdded != miUsuario)
                {   lastUsuarioAdded = miUsuario
                    listaUsuarios.add(miUsuario)
                    // Muy recomendable:
                    (binding.spUsuarios.adapter as ArrayAdapter<Usuario>).notifyDataSetChanged()
                }
            }
            true
        }

    }
}