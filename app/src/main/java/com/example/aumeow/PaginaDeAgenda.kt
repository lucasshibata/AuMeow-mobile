package com.example.aumeow

import android.content.Intent
import android.graphics.Color
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CalendarView
import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.example.aumeow.databinding.ActivityPaginaDeAgendaBinding
import retrofit2.Retrofit

class PaginaDeAgenda : AppCompatActivity() {
    private lateinit var binding: ActivityPaginaDeAgendaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaginaDeAgendaBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.calendarView.setOnDateChangeListener{_, year, month, day ->
            val date = ("%02d".format(day) + "-" + "%02d".format(month+1) + "-" + "%02d".format(year))
            binding.testeTexto.text = date
        }

        binding.voltarImg3.setOnClickListener {
            val ir_para_navegacao = Intent(this, PaginaDeNavegacao::class.java)
            startActivity(ir_para_navegacao)
        }
    }
}