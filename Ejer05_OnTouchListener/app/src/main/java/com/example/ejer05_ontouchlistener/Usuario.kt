package com.example.ejer05_ontouchlistener

data class Usuario(var nombre:String, var password:String){

    override fun toString(): String {
        return nombre.uppercase()
    }
}

