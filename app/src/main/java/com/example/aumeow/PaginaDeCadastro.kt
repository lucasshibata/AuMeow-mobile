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
private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl("https://aumeow.000webhostapp.com")
    .build()
    .create(PaginaDeCadastro.recebeUsuario::class.java)

class PaginaDeCadastro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaginaDeCadastroBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.txtCampoNome.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.cor_linha_txt))
        binding.txtCampoEmail.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.cor_linha_txt))
        binding.txtCampoSenha.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.cor_linha_txt))
        binding.txtRepitaSenha.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.cor_linha_txt))

        binding.voltarImg1.setOnClickListener {
            val ir_para_inicio = Intent(this, MainActivity::class.java)
            startActivity(ir_para_inicio)
        }

        binding.btnCadastro.setOnClickListener {
            val usuario = Usuario()
            usuario.nome = binding.txtCampoNome.toString()
            usuario.email = binding.txtCampoEmail.toString()
            usuario.senha = binding.txtCampoSenha.toString()
            chamaAPI(usuario)
        }
    }

    private fun chamaAPI(usuario: Usuario){
        retrofit.setUsuario(usuario.nome, usuario.email, usuario.senha).enqueue(object:Callback<Usuario>{
            override fun onFailure(call: Call<Usuario>, t: Throwable) {
                Log.d("Erro: ", t.toString())
            }

            override fun onResponse(call: Call<Usuario>, response: Response<Usuario>) {
                if(response.isSuccessful){
                    exibeToast()
                }
            }
        })
    }
    private fun exibeToast(){
        Toast.makeText(this, "Inserido com sucesso", Toast.LENGTH_LONG).show()
    }

    interface recebeUsuario{
        @FormUrlEncoded
        @POST("/insercao_mobile.php")
        fun setUsuario(
            @Field("nome") nome: String,
            @Field("email") email: String,
            @Field("senha") senha: String
        ): Call<Usuario>
    }
}