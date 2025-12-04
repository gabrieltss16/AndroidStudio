package com.example.ejem02_contraintlayout

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ejem02_contraintlayout.databinding.UsuarioBinding

class UsuarioAdapter(val listaUsuario: MutableList<Usuario>): RecyclerView.Adapter<UsuarioAdapter.UsuarioViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UsuarioViewHolder {
        val binding= UsuarioBinding.inflate(
            android.view.LayoutInflater.from(parent.context),
            parent,
            false
        )
        return UsuarioViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: UsuarioViewHolder,
        position: Int
    ) {
        val usuario=listaUsuario.get(position)
        holder.binding.tvNombreUsuario.text=usuario.nombre.toString()
        holder.binding.tvEdad.text=usuario.edad.toString()
        holder.binding.tvMail.text=usuario.email.toString()
    }

    override fun getItemCount(): Int {
        return listaUsuario.size
    }

    class UsuarioViewHolder(val binding: UsuarioBinding): RecyclerView.ViewHolder(binding.root) {

    }

}