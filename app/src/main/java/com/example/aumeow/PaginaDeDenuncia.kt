package com.example.aumeow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class PaginaDeDenuncia : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagina_denuncia)

        val btn_voltar = findViewById<ImageView>(R.id.voltar_img_4)

        btn_voltar.setOnClickListener {
            val ir_para_navegacao = Intent(this, PaginaDeNavegacao::class.java)
            startActivity(ir_para_navegacao)
        }
    }
}