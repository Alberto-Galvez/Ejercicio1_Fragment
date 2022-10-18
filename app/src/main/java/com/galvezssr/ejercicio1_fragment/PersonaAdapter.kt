package com.galvezssr.ejercicio1_fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.galvezssr.ejercicio1_fragment.databinding.ItemListBinding

class PersonaAdapter (val personas: List<Persona>, val listener: (Persona) -> Unit) : RecyclerView.Adapter<PersonaAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        /* INFLAMOS LAS PERSONAS */
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val persona = personas[position]

        holder.bind(persona)
        holder.itemView.setOnClickListener{
            listener(persona)
        }
    }

    override fun getItemCount(): Int {
        return personas.size
    }

    class ViewHolder (private val view: View) : RecyclerView.ViewHolder(view){

        val binding = ItemListBinding.bind(view)
        fun bind (persona: Persona){

            binding.nombrePersona.text = persona.nombre
            binding.telefonoPersona.text = persona.tel
            binding.emailPersona.text = persona.correo
            binding.imagenPersona.glide(persona.imagen)
        }
    }
}

fun ImageView.glide(url: String){
    Glide.with(this).load(url).into(this)

}