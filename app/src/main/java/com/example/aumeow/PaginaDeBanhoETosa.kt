package com.example.aumeow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Adapter
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aumeow.databinding.ActivityPaginaBanhoEtosaBinding

class PaginaDeBanhoETosa : AppCompatActivity() {
    lateinit var binding: ActivityPaginaBanhoEtosaBinding
    var arraylist = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaginaBanhoEtosaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.voltarImg5.setOnClickListener {
            val ir_para_navegacao = Intent(this, PaginaDeNavegacao::class.java)
            startActivity(ir_para_navegacao)
        }

        binding.listaLojas.layoutManager = LinearLayoutManager(this)
    }
}

//class Adapter (val arrayList: ArrayList<String>):RecyclerView<Adapter.ViewHolder>{
//    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
//
//    }
//}