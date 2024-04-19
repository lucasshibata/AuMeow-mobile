package com.example.aumeow

import android.content.Intent
import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_entrar = findViewById<Button>(R.id.btn_entrar)
        val btn_cadastro = findViewById<Button>(R.id.btn_cadastrar)
        val input_email = findViewById<EditText>(R.id.input_email)
        val input_senha = findViewById<EditText>(R.id.input_senha)
        val acessar_direto = findViewById<Button>(R.id.acessar_direto)
        val esqueci_senha = findViewById<TextView>(R.id.txt_recuperacao_senha)

        input_email.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.cor_linha_txt))
        input_senha.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.cor_linha_txt))

        esqueci_senha.setOnClickListener {
            val ir_para_recuperacao = Intent(this, PaginaDeRecuperacaoDeSenha::class.java)
            startActivity(ir_para_recuperacao)
        }

        btn_entrar.setOnClickListener {
            try{
                //criar banco de dados
                val bancoDados = openOrCreateDatabase("DB_AUMEOW", MODE_PRIVATE, null)

                //criar tabela
                bancoDados.execSQL("CREATE TABLE IF NOT EXISTS TB_USUARIOS(email VARCHAR, senha VARCHAR)")

                //inserir dados em uma tabela
                //bancoDados.execSQL("INSERT INTO TB_USUARIOS VALUES ('teste@gmail.com', '6789')")

                val consulta = "SELECT email, senha FROM TB_USUARIOS"

                val cursor = bancoDados.rawQuery(consulta, null)

                //recuperar os indices da nossa tabela
                val indiceEmail = cursor.getColumnIndex("email")
                val indiceSenha = cursor.getColumnIndex("senha")
                cursor.moveToFirst()

                while (cursor != null){
                    val email = cursor.getString(indiceEmail)
                    val senha = cursor.getString(indiceSenha)
                    if (email == input_email.text.toString() && senha == input_senha.text.toString()){
                        Log.i("Resultado", "tá dando certo")
                        val navegar_principal = Intent(this, PaginaDeNavegacao::class.java)
                        startActivity(navegar_principal)
                    }
                    Log.i("Resultado", "emai: $email | senha: $senha")
                    cursor.moveToNext()
                }

            } catch (e: Exception){
                e.printStackTrace()
            }

        }

        acessar_direto.setOnClickListener {
            val navegar_principal = Intent(this, PaginaDeNavegacao::class.java)
            startActivity(navegar_principal)
        }

        btn_cadastro.setOnClickListener {
            val ir_para_cadastro = Intent(this, PaginaDeCadastro::class.java)
            startActivity(ir_para_cadastro)
        }
    }
}