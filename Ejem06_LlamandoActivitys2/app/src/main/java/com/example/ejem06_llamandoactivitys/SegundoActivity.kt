package com.example.ejem06_llamandoactivitys

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ejem06_llamandoactivitys.databinding.ActivitySegundoBinding

class SegundoActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySegundoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySegundoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val usuarioRecibido = intent.getParcelableExtra<Usuario>("DATO",Usuario::class.java)
       /* usuarioRecibido?.let {
            binding.tietNombre2.setText(it.nombre)
            binding.tietEdad2.setText(it.edad.toString())
            binding.tietEmail2.setText(it.email)
        }*/
        binding.user=usuarioRecibido

        binding.bPasarActivity2.setOnClickListener {
            /*val nombre = binding.tietNombre2.text.toString()
            val edad = binding.tietEdad2.text.toString().toIntOrNull() ?: 0
            val email = binding.tietEmail2.text.toString()

            val usuarioDevuelto = Usuario(nombre, edad, email)*/
            val usuarioDevuelto= binding.user

            // Devolver usuario a MainActivity
            /*val data = Intent().apply {
                putExtra("USUARIO_DEVUELTO", usuarioDevuelto)
            }*/

            intent.putExtra("USUARIO_DEVUELTO", usuarioDevuelto)

            setResult(RESULT_OK, intent)
            finish()
        }
    }
}