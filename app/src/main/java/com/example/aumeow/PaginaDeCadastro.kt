package com.example.aumeow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.example.aumeow.databinding.ActivityPaginaDeCadastroBinding
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

private lateinit var binding: ActivityPaginaDeCadastroBinding
private val retrofit = Retrofit.Builder()
    .baseUrl("https://aumeow.000webhostapp.com")
    .build()
    .create(PaginaDeCadastro.recebeUsuario::class.java)

class PaginaDeCadastro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaginaDeCadastroBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val btn_cadastro = findViewById<Button>(R.id.btn_cadastro)

        binding.txtCampoNome.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.cor_linha_txt))
        binding.txtCampoEmail.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.cor_linha_txt))
        binding.txtCampoSenha.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.cor_linha_txt))
        binding.txtRepitaSenha.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.cor_linha_txt))

        binding.voltarImg1.setOnClickListener {
            val ir_para_inicio = Intent(this, MainActivity::class.java)
            startActivity(ir_para_inicio)
        }

        btn_cadastro.setOnClickListener {

        }
    }

    interface recebeUsuario{
        @FormUrlEncoded
        @POST("/autenticacao_mobile.php")
        fun setUsuario(
            @Field("email") email: String,
            @Field("senha") senha: String
        ): Call<Usuario>
    }
}