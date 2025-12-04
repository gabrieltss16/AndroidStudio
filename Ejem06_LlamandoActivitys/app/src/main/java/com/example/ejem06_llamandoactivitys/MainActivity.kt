package com.example.ejem06_llamandoactivitys

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.registerForActivityResult
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejem06_llamandoactivitys.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val llamadaConRetorno=registerForActivityResult(ActivityResultContracts.StartActivityForResult() ) { resultado ->
            if (resultado.resultCode== RESULT_OK) {
                val datoDevuelto= resultado.data?.getStringExtra("dato_devuelto")
                Log.d("depurando","Dato devuelto: $datoDevuelto")
            }
        }




        binding.bPasarActivity.setOnClickListener {
            val valor = binding.tietDato.text.toString()
            val user:Usuario=Usuario(valor)
            Log.d("depurando","Valor a pasar: $valor")

            val testigo: Intent = Intent(this, SegundoActivity::class.java)
            testigo.putExtra("DATO",user)
           /*
            Enviar información al segundo activity
            startActivity(testigo)*/

            llamadaConRetorno.launch(testigo)




        }




    }
}