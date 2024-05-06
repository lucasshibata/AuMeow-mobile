package com.example.aumeow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.aumeow.databinding.ActivityPaginaDeCadastroBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

private lateinit var binding: ActivityPaginaDeCadastroBinding

class PaginaDeCadastro : AppCompatActivity() {

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://aumeow.000webhostapp.com")
        .build()

    private val service = retrofit.create(ApiService::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaginaDeCadastroBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.txtCampoNome.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.cor_linha_txt))
        binding.txtCampoEmail.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.cor_linha_txt))
        binding.txtCampoSenha.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.cor_linha_txt))
        binding.txtRepitaSenha.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.cor_linha_txt))

        // Configurações dos campos de texto

        binding.voltarImg1.setOnClickListener {
            val ir_para_inicio = Intent(this, MainActivity::class.java)
            startActivity(ir_para_inicio)
        }

        binding.btnCadastro.setOnClickListener {
            val nome = binding.txtCampoNome.text.toString()
            val email = binding.txtCampoEmail.text.toString()
            val senha = binding.txtCampoSenha.text.toString()

            val dados = Dados(nome, email, senha)
            chamaAPI(dados)
        }
    }

    private fun chamaAPI(dados: Dados){
        service.setUsuario(dados.nome, dados.email, dados.senha).enqueue(object: Callback<Dados> {
            override fun onFailure(call: Call<Dados>, t: Throwable) {
                Log.d("Erro: ", t.toString())
            }

            override fun onResponse(call: Call<Dados>, response: Response<Dados>) {
                if(response.isSuccessful){
                    exibeToast()
                }
            }
        })
    }

    private fun exibeToast(){
        Toast.makeText(this, "Inserido com sucesso", Toast.LENGTH_LONG).show()
    }
}

data class Dados(
    val nome: String,
    val email: String,
    val senha: String
)

interface ApiService {
    @FormUrlEncoded
    @POST("/insercao_mobile.php")
    fun setUsuario(
        @Field("nome") nome: String,
        @Field("email") email: String,
        @Field("senha") senha: String
    ): Call<Dados>
}