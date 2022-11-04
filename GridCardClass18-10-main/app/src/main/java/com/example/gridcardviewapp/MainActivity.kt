package com.example.gridcardviewapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.GridView

class MainActivity : AppCompatActivity() {
    private lateinit var gVTabla:GridView

    var nombre = arrayListOf<String>("Kemberly","Nelson","Cristina","William")
    var departamento = arrayListOf<String>("San Vicente","San Salvador","Chalatenango","Santa Ana")
    var imagen = arrayOf(
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image3,
        R.drawable.image4,
    )

    var imagenesLista = arrayOf(

        ImgItems(imagen.get(0), nombre.get(0),departamento.get(0)),
        ImgItems(imagen.get(1), nombre.get(1),departamento.get(1)),
        ImgItems(imagen.get(2), nombre.get(2),departamento.get(2)),
        ImgItems(imagen.get(3), nombre.get(3),departamento.get(3))
    )

    var myImagenLista = ArrayList<ImgItems>()

    var adaptador:AdaptadorModificado? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      for (imagen in  imagenesLista) {
    myImagenLista.add(imagen)
  }

        gVTabla = findViewById(R.id.gv_Tabla)

        adaptador = AdaptadorModificado(myImagenLista, this)
        gVTabla.adapter = adaptador
        gVTabla.onItemClickListener = object : AdapterView.OnItemClickListener{
            override fun onItemClick(p0: AdapterView<*>?,
                                     p1: View?
                                     , p2: Int,
                                     p3: Long) {

           var ventana:Intent = Intent(applicationContext,Detalles::class.java)
                ventana.putExtra("imagen",imagen.get(p2))
                ventana.putExtra("nombre",nombre.get(p2))
                ventana.putExtra("departamento",departamento.get(p2))
                startActivity(ventana)

            }




        }
    }
}