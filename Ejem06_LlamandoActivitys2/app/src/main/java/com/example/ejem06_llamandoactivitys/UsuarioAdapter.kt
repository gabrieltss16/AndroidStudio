package com.example.ejem06_llamandoactivitys

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ejem06_llamandoactivitys.databinding.ItemUsuarioBinding

class UsuarioAdapter(private val listaUsuario: MutableList<Usuario>) :
    RecyclerView.Adapter<UsuarioAdapter.UsuarioViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsuarioViewHolder {
        val binding= ItemUsuarioBinding.inflate(LayoutInflater.from(parent.context))
        return UsuarioViewHolder(binding)
       }

    override fun onBindViewHolder(holder: UsuarioViewHolder, position: Int) {
        holder.binding.user= listaUsuario[position]
    }

    override fun getItemCount(): Int = listaUsuario.size

    class UsuarioViewHolder(val binding: ItemUsuarioBinding) : RecyclerView.ViewHolder(binding.root) {
        //val tvUsuario: TextView = itemView.findViewById(R.id.tvUsuario)
    }
}
