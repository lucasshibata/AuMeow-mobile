
package com.example.aumeow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.aumeow.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

private lateinit var binding: ActivityMainBinding
private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl("https://aumeow.000webhostapp.com")
    .build()
    .create(MainActivity.enviaUsuario::class.java)

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.inputEmail.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.cor_linha_txt))
        binding.inputSenha.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.cor_linha_txt))


        binding.btnEntrar.setOnClickListener {
            val usuario = Usuario()
            usuario.email = binding.inputEmail.text.toString()
            usuario.senha = binding.inputSenha.text.toString()
            chamaAPI(usuario)
        }
        binding.txtRecuperacaoSenha.setOnClickListener {
            val ir_para_recuperacao = Intent(this, PaginaDeRecuperacaoDeSenha::class.java)
            startActivity(ir_para_recuperacao)
        }
        binding.acessarDireto.setOnClickListener {
            val navegar_principal = Intent(this, PaginaDeNavegacao::class.java)
            startActivity(navegar_principal)
        }
        binding.btnCadastrar.setOnClickListener {
            val ir_para_cadastro = Intent(this, PaginaDeCadastro::class.java)
            startActivity(ir_para_cadastro)
        }
    }

    private fun chamaAPI(usuario: Usuario) {

        retrofit.setUsuario(usuario.email, usuario.senha).enqueue(object : Callback<Usuario> {
            override fun onFailure(call: Call<Usuario>, t: Throwable) {
                Log.d("Erro: ", t.toString())
            }

            override fun onResponse(call: Call<Usuario>, response: Response<Usuario>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        if (response.body()!!.email.equals("vazio")) {
                            exibeToast(false)
                        } else {
                            exibeToast(true)
                        }
                    }
                }
            }
        })
    }

    private fun exibeToast(respostaServidor: Boolean){
        if(respostaServidor){
            Toast.makeText(this, "Usuário Autenticado", Toast.LENGTH_LONG).show()
            val ir_para_navegacao = Intent(this, PaginaDeNavegacao::class.java)
            startActivity(ir_para_navegacao)
        }else{
            Toast.makeText(this, "Usuário ou Senha incorretos", Toast.LENGTH_LONG).show()
        }
    }
    interface enviaUsuario{
        @FormUrlEncoded
        @POST("/autenticacao_mobile.php")
        fun setUsuario(
            @Field("email") email: String,
            @Field("senha") senha: String
        ): Call<Usuario>
    }
}

class Usuario{
    lateinit var email: String
    lateinit var senha: String
}