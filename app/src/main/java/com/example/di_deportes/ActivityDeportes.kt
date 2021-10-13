package com.example.di_deportes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.di_deportes.databinding.ActivityDeportesBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ActivityDeportes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deportes)

        val binding = ActivityDeportesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listaItems = ArrayList<ItemDeporte>()
        listaItems.add(ItemDeporte(R.drawable.baloncesto,CheckBox(this)))
        listaItems.get(0).checkBoxNombre.setText(R.string.deporte1)

        listaItems.add(ItemDeporte(R.drawable.beisbol,CheckBox(this)))
        listaItems.get(1).checkBoxNombre.setText(R.string.deporte2)

        listaItems.add(ItemDeporte(R.drawable.ciclismo,CheckBox(this)))
        listaItems.get(2).checkBoxNombre.setText(R.string.deporte3)

        listaItems.add(ItemDeporte(R.drawable.futbol,CheckBox(this)))
        listaItems.get(3).checkBoxNombre.setText(R.string.deporte4)

        listaItems.add(ItemDeporte(R.drawable.golf,CheckBox(this)))
        listaItems.get(4).checkBoxNombre.setText(R.string.deporte5)

        listaItems.add(ItemDeporte(R.drawable.hipica,CheckBox(this)))
        listaItems.get(5).checkBoxNombre.setText(R.string.deporte6)

        listaItems.add(ItemDeporte(R.drawable.natacion,CheckBox(this)))
        listaItems.get(6).checkBoxNombre.setText(R.string.deporte7)

        listaItems.add(ItemDeporte(R.drawable.pinpon,CheckBox(this)))
        listaItems.get(7).checkBoxNombre.setText(R.string.deporte8)

        listaItems.add(ItemDeporte(R.drawable.tenis,CheckBox(this)))
        listaItems.get(8).checkBoxNombre.setText(R.string.deporte9)


        val recView = findViewById<RecyclerView>(R.id.rvDeporte)
        val fabSeleccion = findViewById<FloatingActionButton>(R.id.fabSeleccion)

        recView.setHasFixedSize(true)
        recView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        val adaptador = ItemDeporteAdapter(listaItems)
        recView.adapter = adaptador
        recView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        
        
        adaptador.onClick = {
            Toast.makeText(this@ActivityDeportes, "Ignorar"+listaItems[recView.getChildAdapterPosition(it)], Toast.LENGTH_LONG).show()
        }
        fabSeleccion.setOnClickListener{
            Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show()
            for (item in listaItems)
                if (item.checkBoxNombre.isChecked)
                    Toast.makeText(this@ActivityDeportes,"asdf"+listaItems[recView.getChildAdapterPosition(it)].checkBoxNombre.text,Toast.LENGTH_SHORT).show()
        }
    }
}