package com.example.ejem01_holamundo

data class Usuario(val nombre: String, val edad: Int, val soltero: Boolean = true, val ciudad: String = "" , val colorFavorito: String = "" ) {
    override fun toString(): String {
        return nombre
    }

}
