package com.example.aumeow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.core.content.ContextCompat


class PaginaDeCadastro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagina_de_cadastro)

        val btn_voltar = findViewById<ImageView>(R.id.voltar_img_1)
        val btn_cadastro = findViewById<Button>(R.id.btn_cadastro)
        val nomeEditText = findViewById<EditText>(R.id.txt_campo_nome)
        val emailEditText = findViewById<EditText>(R.id.txt_campo_email)
        val senhaEditText = findViewById<EditText>(R.id.txt_campo_senha)
        val repitasenhaEditText = findViewById<EditText>(R.id.txt_repita_senha)

        nomeEditText.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.cor_linha_txt))
        emailEditText.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.cor_linha_txt))
        senhaEditText.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.cor_linha_txt))
        repitasenhaEditText.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.cor_linha_txt))

        btn_voltar.setOnClickListener {
            val ir_para_inicio = Intent(this, MainActivity::class.java)
            startActivity(ir_para_inicio)
        }

        btn_cadastro.setOnClickListener {

        }
    }
}