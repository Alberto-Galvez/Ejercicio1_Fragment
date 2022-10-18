package com.galvezssr.ejercicio1_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.os.bundleOf
import com.galvezssr.ejercicio1_fragment.databinding.FragmentListaPersonasBinding

/* INFLAMOS LA VISTA A TRAVES DEL CONSTRUCTOR */
class FragmentListaContactos : Fragment(R.layout.fragment_lista_personas) {

    /* CREAMOS LAS VARIABLES, QUE EN ESTE CASO ES UNA LISTA DE PERSONAS */
    val listaPersonas = listOf(
        Persona("https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fimages.guns.com%2Fwordpress%2F2016%2F09%2FPepe-3.jpg&f=1&nofb=1&ipt=17e590ad82c0e8255b4d59361652fe562fb53a3640b6cb470ccaa7bf7ce7f179&ipo=images", "Alberto Galvez", "634592401", "galvezssr@gmail.com"),
        Persona("https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fimages.guns.com%2Fwordpress%2F2016%2F09%2FPepe-3.jpg&f=1&nofb=1&ipt=17e590ad82c0e8255b4d59361652fe562fb53a3640b6cb470ccaa7bf7ce7f179&ipo=images", "Ismael barbero", "987412365", "ismabar@gmail.com"),
        Persona("https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fimages.guns.com%2Fwordpress%2F2016%2F09%2FPepe-3.jpg&f=1&nofb=1&ipt=17e590ad82c0e8255b4d59361652fe562fb53a3640b6cb470ccaa7bf7ce7f179&ipo=images", "Pedro Jurado", "963741456", "pjurado@gmail.com"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentListaPersonasBinding.bind(view)
        binding.recycler.adapter = PersonaAdapter (listaPersonas){
                persona ->  navigateTo(persona)
        }

    }

    /* CREAMOS EL METODO "navigateTo" QUE SERA INDICADO POR UN FRAGMENT QUE DEBE CAMBIAR EN EL RECYCLER VIEW
    * CUANDO PULSEMOS SOBRE UNA PERSONA, QUE ESTE NOS LLEVARA AL "DetailFragment" */
    private fun navigateTo(contacto: Persona) {
        val fragment = DetailFragment()
        fragment.arguments = bundleOf(DetailFragment.EXTRA_PERSONA to contacto)

        parentFragmentManager.beginTransaction()
            .setCustomAnimations(R.anim.slide_right_in,
                R.anim.slide_left_out,
                R.anim.slide_left_in,
                R.anim.slide_right_out)
            .replace(R.id.fragmentContainerView, fragment)
            .setReorderingAllowed(true)
            .addToBackStack(null)
            .commit()
    }


}