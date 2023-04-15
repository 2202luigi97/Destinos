package com.luiscuadra.destinos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.luiscuadra.destinos.databinding.ActivityDestinoDetailsBinding
import com.squareup.picasso.Picasso

class DestinoDetails : AppCompatActivity() {

    private lateinit var binding: ActivityDestinoDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDestinoDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Get the Intent that started this activity and extract the string
        val titulo = intent.getStringExtra("TITULO")
        val descripcion = intent.getStringExtra("DESCRIPCION")
        val foto = intent.getStringExtra("FOTO")

        binding.txtTitle.text = titulo
        binding.txtdesc.text = descripcion
        Picasso.get().load(foto).into(binding.imgfondo);
    }

    fun finalizar(view: View){
        finish()
    }

}