package com.example.aumeow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import com.example.aumeow.databinding.ActivityPaginaDenunciaBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


class PaginaDeDenuncia : AppCompatActivity() {
    private lateinit var binding: ActivityPaginaDenunciaBinding
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://aumeow.000webhostapp.com")
        .build()

    private val service = retrofit.create(ApiServiceDenuncia::class.java)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaginaDenunciaBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.txtNomeDenuncia.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.cor_linha_txt))
        binding.txtCpfDenuncia.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.cor_linha_txt))
        binding.txtEnderecoDenuncia.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.cor_linha_txt))
        binding.txtTelefoneDenuncia.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.cor_linha_txt))
        binding.txtEspecieDenuncia.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.cor_linha_txt))
        binding.txtRacaDenuncia.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.cor_linha_txt))
        binding.txtPelagemDenuncia.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.cor_linha_txt))
        binding.txtSinaisDenuncia.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.cor_linha_txt))
        binding.txtLocalizacaoDenuncia.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.cor_linha_txt))
        binding.txtSituacaoDenuncia.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.cor_linha_txt))

        binding.voltarImg4.setOnClickListener {
            val irParaNavegacao = Intent(this, PaginaDeNavegacao::class.java)
            startActivity(irParaNavegacao)
        }

        binding.btnEnviarDenuncia.setOnClickListener{
            val nome = binding.txtNomeDenuncia.text.toString()
            val cpf = binding.txtCpfDenuncia.text.toString()
            val endereco = binding.txtEnderecoDenuncia.text.toString()
            val telefone = binding.txtTelefoneDenuncia.text.toString()
            val especie = binding.txtEspecieDenuncia.text.toString()
            val raca = binding.txtRacaDenuncia.text.toString()
            val pelagem = binding.txtPelagemDenuncia.text.toString()
            val sinais = binding.txtSinaisDenuncia.text.toString()
            val localizacao = binding.txtLocalizacaoDenuncia.text.toString()
            val situacao = binding.txtSituacaoDenuncia.text.toString()

            val denuncia = Denuncia(nome, cpf, endereco, telefone, especie, raca, pelagem, sinais, localizacao, situacao)
            chamaAPI(denuncia)
        }

    }
    private fun chamaAPI(denuncia: Denuncia){
        service.setUsuario(denuncia.nome, denuncia.cpf, denuncia.endereco, denuncia.telefone, denuncia.especie,
            denuncia.raca, denuncia.pelagem,denuncia.sinais, denuncia.localizacao, denuncia.situacao).enqueue(object: Callback<Denuncia> {
            override fun onFailure(call: Call<Denuncia>, t: Throwable) {
                Log.d("Erro: ", t.toString())
                val irParaNavegacao = Intent(this@PaginaDeDenuncia, PaginaDeNavegacao::class.java)
                startActivity(irParaNavegacao)
                finish()
            }

            override fun onResponse(call: Call<Denuncia>, response: Response<Denuncia>) {
                if(response.isSuccessful){
                    val irParaNavegacao = Intent(this@PaginaDeDenuncia, PaginaDeNavegacao::class.java)
                    startActivity(irParaNavegacao)
                    finish()
                }
            }
        })
    }
}

data class Denuncia(
    val nome: String,
    val cpf: String,
    val endereco: String,
    val telefone: String,
    val especie: String,
    val raca: String,
    val pelagem: String,
    val sinais: String,
    val localizacao: String,
    val situacao: String
)

interface ApiServiceDenuncia {
    @FormUrlEncoded
    @POST("/arquivos_php/salvar_denuncia.php")
    fun setUsuario(
        @Field("nome") nome: String,
        @Field("CPF") cpf: String,
        @Field("endereco") endereco: String,
        @Field("telefone") telefone: String,
        @Field("especie") especie: String,
        @Field("raca") raca: String,
        @Field("pelagem") pelagem: String,
        @Field("sinais_particulares") sinaisParticulares: String,
        @Field("localizacao") localizacao: String,
        @Field("situacao_do_animal") situacaoDoAnimal: String,
    ): Call<Denuncia>
}