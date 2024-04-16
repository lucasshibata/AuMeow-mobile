package com.example.aumeow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class PaginaDeRecuperacaoDeSenha : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagina_de_recuperacao_de_senha)

        val voltar = findViewById<ImageView>(R.id.btn_voltar_recu)

        voltar.setOnClickListener {
            val ir_para_login = Intent(this, MainActivity::class.java)
            startActivity(ir_para_login)
        }
    }
}