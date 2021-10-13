package com.example.di_deportes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class ItemDeporteAdapter(var items: ArrayList<ItemDeporte>) : RecyclerView.Adapter<ItemDeporteAdapter.TarjViewHolder>() {
    lateinit var onClick : (View) -> Unit


    class TarjViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var checkBoxNombre: CheckBox
        private var imagen: ImageView

        init {
            checkBoxNombre = itemView.findViewById(R.id.cbDeporte)
            imagen = itemView.findViewById(R.id.ivImagenDeporte)
        }

        fun bindTarjeta(t: ItemDeporte, onClick: (View) -> Unit) = with(itemView) {
            checkBoxNombre.setText(t.checkBoxNombre.text)
            imagen.setImageResource(t.imagen)
            setOnClickListener { onClick(itemView) }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): TarjViewHolder {
        val itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_deporte, viewGroup, false)
        return TarjViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: TarjViewHolder, pos: Int) {
        val item = items.get(pos)
        viewHolder.bindTarjeta(item, onClick)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

