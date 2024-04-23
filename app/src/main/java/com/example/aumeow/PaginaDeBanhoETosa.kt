package com.example.aumeow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class PaginaDeBanhoETosa : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagina_banho_etosa)

        val btn_voltar = findViewById<ImageView>(R.id.voltar_img_5)

        btn_voltar.setOnClickListener {
            val ir_para_navegacao = Intent(this, PaginaDeNavegacao::class.java)
            startActivity(ir_para_navegacao)
        }
    }
}