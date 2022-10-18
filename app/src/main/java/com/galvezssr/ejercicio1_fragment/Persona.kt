package com.galvezssr.ejercicio1_fragment

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Persona (val imagen:String, val nombre:String, val tel: String, val correo: String): Parcelable