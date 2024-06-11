package com.example.aumeow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aumeow.adapter.AdapterClass
import com.example.aumeow.databinding.ActivityPaginaDeHospedagemBinding
import com.example.aumeow.databinding.ActivityPaginaDeVacinacaoBinding
import com.example.aumeow.domain.DataClass

class PaginaDeVacinacao : AppCompatActivity() {
    lateinit var binding: ActivityPaginaDeVacinacaoBinding

    private lateinit var recyclerView: RecyclerView
    private  lateinit var  dataList: ArrayList<DataClass>
    lateinit var imageList: Array<Int>
    lateinit var nomeList: Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaginaDeVacinacaoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnVoltar7.setOnClickListener{
            val ir_para_navegacao = Intent(this, PaginaDeNavegacao::class.java)
            startActivity(ir_para_navegacao)
        }

        imageList = arrayOf(
            R.drawable.fred_img_exemple,
            R.drawable.logo_img,
            R.drawable.paw_img
        )
        nomeList = arrayOf(
            "fred imagem",
            "imagem da logo",
            "imagem de patinha"
        )

        recyclerView = binding.lugaresVacinar
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        dataList = arrayListOf<DataClass>()
        getData()
    }
    private fun getData(){
        for(i in imageList.indices){
            val dataClass = DataClass(imageList[i], nomeList[i])
            dataList.add(dataClass)
        }
        recyclerView.adapter = AdapterClass(dataList)
    }
}