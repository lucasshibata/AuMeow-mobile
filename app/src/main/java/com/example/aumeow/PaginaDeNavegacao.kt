package com.example.aumeow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.aumeow.databinding.ActivityMainBinding
import com.example.aumeow.databinding.ActivityPaginaDeNavegacaoBinding

class PaginaDeNavegacao : AppCompatActivity() {
    private lateinit var binding: ActivityPaginaDeNavegacaoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaginaDeNavegacaoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.adocaoBtn.setOnClickListener {
            val ir_para_adocao = Intent(this, PaginaDeAdocao::class.java)
            startActivity(ir_para_adocao)
        }
        binding.denunciaBtn.setOnClickListener {
            val ir_para_denuncia = Intent(this, PaginaDeDenuncia::class.java)
            startActivity(ir_para_denuncia)
        }
        binding.banhoTosaBtn.setOnClickListener {
            val ir_para_banho_tosa = Intent(this, PaginaDeBanhoETosa::class.java)
            startActivity(ir_para_banho_tosa)
        }
        binding.vacinacaoBtn.setOnClickListener {
            val ir_para_vacinacao = Intent(this, PaginaDeVacinacao::class.java)
            startActivity(ir_para_vacinacao)
        }
        binding.adestrarBtn.setOnClickListener {
            val ir_para_adestracao = Intent(this, PaginaDeAdestramento::class.java)
            startActivity(ir_para_adestracao)
        }
        binding.hospedagemBtn.setOnClickListener {
            val ir_para_hospedagem = Intent(this, PaginaDeHospedagem::class.java)
            startActivity(ir_para_hospedagem)
        }
        binding.feedbackBtn.setOnClickListener {
            val ir_para_feedback = Intent(this, PaginaDeFeedback::class.java)
            startActivity(ir_para_feedback)
        }
    }
}