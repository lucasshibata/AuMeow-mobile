package com.example.aumeow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView

import android.widget.Toast
import com.google.gson.Gson
import okhttp3.*
import java.lang.Exception


import java.sql.DriverManager

class PaginaDeCadastro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagina_de_cadastro)

        val btn_voltar = findViewById<ImageView>(R.id.voltar_img)
        val btn_cadastro = findViewById<Button>(R.id.btn_cadastro)
        val nomeEditText = findViewById<EditText>(R.id.txt_campo_nome)
        val emailEditText = findViewById<EditText>(R.id.txt_campo_email)
        val senhaEditText = findViewById<EditText>(R.id.txt_campo_senha)

        btn_voltar.setOnClickListener {
            val ir_para_inicio = Intent(this, MainActivity::class.java)
            startActivity(ir_para_inicio)
        }

        btn_cadastro.setOnClickListener {

        }
    }
}