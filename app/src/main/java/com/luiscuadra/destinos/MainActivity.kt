package com.luiscuadra.destinos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.luiscuadra.destinos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var destino:ArrayList<Destinos> = ArrayList()
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        destino.add(
            Destinos("París, Francia",
                "Conocida como la Ciudad del Amor, París es un destino turístico popular gracias a sus magníficos museos, elegantes tiendas y famosos monumentos como la Torre Eiffel.",
                "https://www.viajarafrancia.com/wp-content/uploads/2016/04/Paris-760x500.jpg")
        )
        destino.add(
            Destinos("Nueva York, Estados Unidos",
                "La ciudad que nunca duerme ofrece infinitas posibilidades de exploración, desde tiendas y restaurantes de clase mundial hasta impresionantes rascacielos y atracciones turísticas como Central Park y la Estatua de la Libertad.",
                "https://www.lanacion.com.ar/resizer/HPWQnuyJ7U2pq-7gh-baactRo5U=/1920x0/filters:format(webp):quality(80)/cloudfront-us-east-1.images.arcpublishing.com/lanacionar/RGTEIMFAMNBKXCVLO2EEUTH3SY.jpg")
        )
        destino.add(
            Destinos("Barcelona, España",
                "Esta ciudad costera española es conocida por su arquitectura única, su deliciosa comida y su vibrante vida nocturna. El Parque Güell y la Sagrada Familia son dos de las atracciones turísticas más populares.",
                "https://e00-elmundo.uecdn.es/assets/multimedia/imagenes/2023/02/16/16765451516678.jpg")
        )
        destino.add(
            Destinos("Sídney, Australia",
                "Esta ciudad australiana cuenta con una impresionante mezcla de playas, parques, museos y restaurantes, todo ello con el impresionante telón de fondo del icónico Opera House de Sídney.",
                "https://www.seabourn.com/content/dam/sbn65/inventory-assets/ports/p/syd/SYD1.jpg.image.750.563.low.jpg")
        )

        destino.add(
            Destinos("Bangkok, Tailandia",
                "La capital de Tailandia es un destino turístico emocionante y lleno de vida, con una gran cantidad de templos, mercados, bares y restaurantes para explorar.",
                "https://imagenes.elpais.com/resizer/YJlZw1laFnbCL58ZY7x_Mc7wqyQ=/414x0/cloudfront-eu-central-1.images.arcpublishing.com/prisa/VXSEYFTVUFDGPJH6BZFVCGH6OU.jpg")
        )
        destino.add(
            Destinos("Ámsterdam, Países Bajos",
                "Esta ciudad es famosa por sus canales, sus bicicletas y sus cafeterías. El Rijksmuseum y el Museo Van Gogh son dos de las atracciones turísticas más populares.",
                "https://media.timeout.com/images/105504583/750/422/image.jpg")
        )
        destino.add(
            Destinos("Rio de Janeiro, Brasil",
                "Conocida por sus hermosas playas, su vida nocturna vibrante y su cultura única, Río de Janeiro es uno de los destinos turísticos más populares de Sudamérica.",
                "https://ilamdir.org/blobs/ilamdir/w1280h720/328/2019/51/5088ba.jpg")
        )
        destino.add(
            Destinos("Roma, Italia",
                "Conocida por sus antiguas ruinas y su deliciosa comida, Roma es un destino turístico popular gracias a su mezcla única de historia y modernidad.",
                "https://www.viajaraitalia.com/wp-content/uploads/2011/05/Colosseum_in_Rome_Italy.jpg")
        )
        destino.add(
            Destinos("Tokio, Japón",
                "Esta metrópolis es un destino turístico emocionante y lleno de vida, con una gran cantidad de tiendas, restaurantes y atracciones turísticas para explorar.",
                "https://content.skyscnr.com/m/2ffd81585221489a/original/eyeem_103811280-jpg.jpg")
        )

        val adaptador = MyAdapter(MainActivity@this, destino)
        binding.ListaDestino.adapter = adaptador

        //Click a cada elemento del ListView
        binding.ListaDestino.setOnItemClickListener { parent, view, position, id ->
            //Toast.makeText(this, "Hizo clickl en ${peliculas[id.toInt()].titulo}", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, DestinoDetails::class.java).apply {
                putExtra("TITULO", destino[id.toInt()].title)
                putExtra("DESCRIPCION", destino[id.toInt()].descripcion)
                putExtra("FOTO", destino[id.toInt()].imgurl)
            }
            startActivity(intent)
        }
    }


}