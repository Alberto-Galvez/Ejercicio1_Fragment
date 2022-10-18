package com.galvezssr.ejercicio1_fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.galvezssr.ejercicio1_fragment.databinding.FragmentDetailPersonaBinding

class DetailFragment : Fragment(R.layout.fragment_detail_persona) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentDetailPersonaBinding.bind(view)

        val persona = arguments?.getParcelable<Persona>(EXTRA_PERSONA)
        if (persona != null) {

            binding.nombrePersona.text = persona.nombre
            binding.imagenPersona.glide(persona.imagen)

            binding.botonLlamar.setOnClickListener{

                val telIntent =  Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + persona.tel))
                startActivity(telIntent)
            }

            binding.botonEmail.setOnClickListener{

                val uri = Uri.parse("mailto:" + persona.correo)
                val emailIntent = Intent(
                    Intent.ACTION_SENDTO, uri
                )
                startActivity(emailIntent)
            }

        }
    }

    companion object {
        const val EXTRA_PERSONA = "EXTRA_PERSONA"
        fun create (contacto: Persona){
            /* FUNCION VACIA */
        }
    }
}
