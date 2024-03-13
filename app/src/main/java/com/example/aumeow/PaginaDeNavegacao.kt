package com.example.aumeow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class PaginaDeNavegacao : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagina_de_navegacao)

        val btn_adocao = findViewById<Button>(R.id.adocao_btn)
        val btn_denuncia = findViewById<Button>(R.id.denuncia_btn)
        val btn_banho_tosa = findViewById<Button>(R.id.banho_tosa_btn)
        val btn_vacinacao = findViewById<Button>(R.id.vacinacao_btn)
        val btn_adestracao = findViewById<Button>(R.id.adestrar_btn)
        val btn_hospedagem = findViewById<Button>(R.id.hospedagem_btn)
        val btn_agendamento = findViewById<Button>(R.id.agenda_btn)
        val btn_feedback = findViewById<Button>(R.id.feedback_btn)


        btn_adocao.setOnClickListener {
            val ir_para_adocao = Intent(this, PaginaDeAdocao::class.java)
            startActivity(ir_para_adocao)
        }
        btn_denuncia.setOnClickListener {
            val ir_para_denuncia = Intent(this, PaginaDeDenuncia::class.java)
            startActivity(ir_para_denuncia)
        }
        btn_banho_tosa.setOnClickListener {
            val ir_para_banho_tosa = Intent(this, PaginaDeBanhoETosa::class.java)
            startActivity(ir_para_banho_tosa)
        }
        btn_vacinacao.setOnClickListener {
            val ir_para_vacinacao = Intent(this, PaginaDeVacinacao::class.java)
            startActivity(ir_para_vacinacao)
        }
        btn_adestracao.setOnClickListener {
            val ir_para_adestracao = Intent(this, PaginaDeAdestracao::class.java)
            startActivity(ir_para_adestracao)
        }
        btn_hospedagem.setOnClickListener {
            val ir_para_hospedagem = Intent(this, PaginaDeHospedagem::class.java)
            startActivity(ir_para_hospedagem)
        }
        btn_agendamento.setOnClickListener {
            val ir_para_agendamento = Intent(this, PaginaDeAgendamento::class.java)
            startActivity(ir_para_agendamento)
        }
        btn_feedback.setOnClickListener {
            val ir_para_feedback = Intent(this, PaginaDeFeedback::class.java)
            startActivity(ir_para_feedback)
        }

    }
}