package com.example.gridcardviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class Detalles : AppCompatActivity() {

    lateinit var ivImgFoto: ImageView
    lateinit var  tv_nombre: TextView
    lateinit var  tvDepartamentos: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalles)


        ivImgFoto = findViewById(R.id.imgFoto)
        tv_nombre = findViewById(R.id.textView)
        tvDepartamentos = findViewById(R.id.textView2)

        val bundle:Bundle = getIntent().getExtras()!!

        ivImgFoto.setImageResource(bundle.getInt("imagen"))
        tv_nombre.setText(bundle.getString("nombre"))
        tvDepartamentos.setText(bundle.getString("departamentos"))







    }
}