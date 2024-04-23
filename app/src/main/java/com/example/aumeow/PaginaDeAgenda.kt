package com.example.aumeow

import android.content.Intent
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CalendarView
import android.widget.ImageView
import androidx.core.content.ContextCompat

class PaginaDeAgenda : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagina_de_agenda)

        val btn_voltar = findViewById<ImageView>(R.id.voltar_img_3)
        val calendario = findViewById<CalendarView>(R.id.calendarView)


        btn_voltar.setOnClickListener {
            val ir_para_navegacao = Intent(this, PaginaDeNavegacao::class.java)
            startActivity(ir_para_navegacao)
        }
    }
}