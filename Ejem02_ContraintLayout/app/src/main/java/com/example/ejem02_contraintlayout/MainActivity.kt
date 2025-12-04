package com.example.ejem02_contraintlayout

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejem02_contraintlayout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("depurando","onCreate MainActivity")

        /*var pulsacion= object : View.OnClickListener {
            override fun onClick(v: View?) {
                Log.d("depurando","Pulsado")
            }
        }
       var pulsacion= View.OnClickListener() { boton ->
            Log.d("depurando","Pulsado")
        }*/
        var pulsacion= View.OnClickListener() {
            Log.d("depurando","Pulsado")
            (binding.lvNombres.adapter as ArrayAdapter<String>).add(binding.tietNombre.text.toString())


        }

        binding.b1.setOnClickListener (pulsacion)
        binding.b2.setOnClickListener ( pulsacion )
        binding.b3.setOnClickListener ( pulsacion )


        //var listaDatos=listOf("Elemento 1","Elemento 2","Elemento 3","Elemento 4","Elemento 5")
        var listaDatos=ArrayList<String>()
        listaDatos.add("Elemento A")
        listaDatos.add("Elemento B")
        listaDatos.add("Elemento C")
        var adaptador= ArrayAdapter(this,android.R.layout.simple_list_item_1,listaDatos)
        binding.lvNombres.adapter=adaptador

    }
}