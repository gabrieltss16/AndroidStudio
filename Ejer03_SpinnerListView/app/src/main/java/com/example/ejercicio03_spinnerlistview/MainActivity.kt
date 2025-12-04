package com.example.ejercicio03_spinnerlistview

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.ejercicio03_spinnerlistview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val elementos = mutableListOf("Elemento1", "Elemento2", "Elemento3")


        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            elementos
        )

        binding.lvLista.adapter = adapter


        binding.bAniadir.setOnClickListener {
            val texto = binding.tiInsertarTexto.text.toString()

            if (texto.isNotBlank()) {
                elementos.add(texto)
                adapter.notifyDataSetChanged()
                binding.tiInsertarTexto.setText("")
                Log.d("depurando", "Añadido: $texto")
            }
        }


        binding.bBorrar.setOnClickListener {
            if (elementos.isNotEmpty()) {
                val eliminado = elementos.removeAt(elementos.size - 1)
                adapter.notifyDataSetChanged()
                Log.d("depurando", "Eliminado: $eliminado")
            }
        }


        binding.lvLista.setOnItemClickListener { _, view, position, _ ->
            val texto = (view as TextView).text.toString()
            elementos.removeAt(position)
            adapter.notifyDataSetChanged()
            Log.d("depurando", "Eliminado al pulsar: $texto")
        }
    }
}
