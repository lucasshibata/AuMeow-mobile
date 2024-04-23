package com.example.aumeow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import androidx.core.content.ContextCompat

class PaginaDeRecuperacaoDeSenha : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagina_de_recuperacao_de_senha)

        val voltar = findViewById<ImageView>(R.id.btn_voltar_recu)
        val email = findViewById<EditText>(R.id.txt_email_recu)

        email.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.cor_linha_txt))

        voltar.setOnClickListener {
            val ir_para_login = Intent(this, MainActivity::class.java)
            startActivity(ir_para_login)
        }
    }
}