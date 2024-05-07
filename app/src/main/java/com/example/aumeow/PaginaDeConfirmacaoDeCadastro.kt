package com.example.aumeow

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.aumeow.databinding.ActivityPaginaDeConfirmacaoDeCadastroBinding

private lateinit var binding: ActivityPaginaDeConfirmacaoDeCadastroBinding
class PaginaDeConfirmacaoDeCadastro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaginaDeConfirmacaoDeCadastroBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnVoltarInicio.setOnClickListener{
            val ir_para_inicio = Intent(this, MainActivity::class.java)
            startActivity(ir_para_inicio)
        }
    }
}