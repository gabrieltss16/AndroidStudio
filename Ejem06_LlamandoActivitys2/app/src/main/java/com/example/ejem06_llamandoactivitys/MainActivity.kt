package com.example.ejem06_llamandoactivitys

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ejem06_llamandoactivitys.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pepe: Usuario= Usuario("Pepe",30,"a@b.com")
       /* binding.tietNombre.setText(pepe.nombre)
        binding.tietEdad.setText(pepe.edad.toString())
        binding.tietEmail.setText(pepe.email)*/
        binding.userUsuario=pepe



        val listaUsuarios = mutableListOf<Usuario>()

        // Registrar la actividad para recibir resultados
        val llamadaConRetorno =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { resultado ->
                if (resultado.resultCode == RESULT_OK) {
                    val usuarioDevuelto: Usuario = resultado.data?.getParcelableExtra<Usuario>("USUARIO_DEVUELTO",Usuario::class.java) as Usuario
                    listaUsuarios.add(usuarioDevuelto)
                    //binding.rvUsuarios.adapter?.notifyItemInserted(listaUsuarios.size - 1)
                    binding.rvUsuarios.adapter?.notifyDataSetChanged()
                    //binding.rvUsuarios.scrollToPosition(listaUsuarios.size - 1)


                    /* usuarioDevuelto?.let {
                         // Agregamos el usuario recibido y notificamos al Adapter
                         listaUsuarios.add(it)
                         adapter.notifyItemInserted(listaUsuarios.size - 1)
                         binding.rvUsuarios.scrollToPosition(listaUsuarios.size - 1)
                     }*/
                } else {
                    Snackbar.make(binding.bPasarActivity2,"No se han cambiado datos",Snackbar.LENGTH_SHORT).show()
                }
            }


        // Inicializamos el Adapter y RecyclerView
        val adapter = UsuarioAdapter(listaUsuarios)
        binding.rvUsuarios.adapter = adapter
        binding.rvUsuarios.layoutManager = LinearLayoutManager(this)

        // Botón para pasar a la segunda actividad
        binding.bPasarActivity2.setOnClickListener {
            val nombre = binding.tietNombre.text.toString()
            val edad = binding.tietEdad.text.toString().toIntOrNull() ?: 0
            val email = binding.tietEmail.text.toString()

            val usuario = Usuario(nombre, edad, email)

            // Lanzamos Segunda Activity sin agregar a la lista todavía
            val intent = Intent(this, SegundoActivity::class.java)
            intent.putExtra("DATO", usuario)
            llamadaConRetorno.launch(intent)
        }
    }
}
