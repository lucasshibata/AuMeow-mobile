package com.example.aumeow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.core.content.ContextCompat

class PaginaDeFeedback : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagina_de_feedback)

        val sugestao = findViewById<EditText>(R.id.caixa_sugestao)

        sugestao.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.cor_borda_botão))

    }
}