package com.example.ejem01_holamundo

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejem01_holamundo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val pepe: Usuario= Usuario("Juan", 77,false)
        Log.d("depurando", "Hola "+pepe)
        binding.user=pepe


        binding.rgColorFavorito.setOnCheckedChangeListener { group, checkedId ->
            //Log.d("depurando",findViewById<RadioButton>(checkedId).text.toString())
            Log.d("depurando",group.checkedRadioButtonId.toString()+ " - "+checkedId)
            /*if (group.checkedRadioButtonId==binding.rbAzul.id){
                Log.d("depurando","Azul seleccionado")
            } else if (group.checkedRadioButtonId==binding.rbRojo.id){
                Log.d("depurando","Rojo seleccionado")
            } else if (group.checkedRadioButtonId==binding.rbVerde.id){
                Log.d("depurando","Verde seleccionado")
            }*/
            when (group.checkedRadioButtonId) {
                binding.rbAzul.id -> Log.d("depurando","Azul seleccionado")
                binding.rbRojo.id -> Log.d("depurando","Rojo seleccionado")
                binding.rbVerde.id -> Log.d("depurando","Verde seleccionado")
            }
        }




        binding.bSaludar.setOnClickListener {
            val user:Usuario = Usuario(binding.tietNombre.text.toString()
                                    ,binding.tietEdad.text.toString().toInt()
            ,binding.cbSoltero.isChecked,binding.spCiudades.selectedItem.toString(),
                findViewById<RadioButton>(binding.rgColorFavorito.checkedRadioButtonId).text.toString())


                /*binding.rgColorFavorito.let { rg ->
                    when (rg.checkedRadioButtonId) {
                        binding.rbRojo.id -> "Rojo"
                        binding.rbVerde.id -> "Verde"
                        binding.rbAzul.id -> "Azul"
                        else -> ""
                    }
                }*/



            Log.d("depurando", "Hola "+user)

        }

        val datos: List<Usuario> = listOf(Usuario("Ana", 23),
            Usuario("Luis", 34,false),
            Usuario("María", 45),
            Usuario("Pedro", 56,false),
            Usuario("Marta", 67),
            Usuario("Carlos", 78,false)
        )

        val adapterDatos: ArrayAdapter<Usuario> = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            datos
        )
        binding.lvListado.adapter  = adapterDatos
        binding.spListado.adapter = adapterDatos

        binding.lvListado.onItemClickListener =
            AdapterView.OnItemClickListener { adaptador, componentePulsado, posicion, idComponente ->
                Log.d("depurando", adaptador.getItemAtPosition(posicion).toString())
            }
        binding.spListado.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                adaptador: AdapterView<*>?,
                componentePulsado: View?,
                posicion: Int,
                idComponente: Long
            ) {
                 Log.d("depurando", (adaptador?.selectedItem as Usuario).edad.toString())
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }


        binding.cbSoltero.setOnCheckedChangeListener { checkBoxSoltero, estaSeleccionado ->
            Log.d("depurando", "El checkbox de soltero está $estaSeleccionado")
        }

    }
}