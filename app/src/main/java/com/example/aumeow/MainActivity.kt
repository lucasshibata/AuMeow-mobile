package com.example.aumeow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_entrar = findViewById<Button>(R.id.btn_entrar)

        btn_entrar.setOnClickListener {
            val navegar_principal = Intent(this, PaginaDeNavegacao::class.java)
            startActivity(navegar_principal)
        }
    }
}