package com.example.recycle_view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recycle_view.databinding.ItemDisasterBinding

typealias onClickDisaster = (Disaster) -> Unit
typealias onClickText = (Disaster) -> Unit

class DisasterAdaptor(
    private val listDisaster: List<Disaster>,
    private val onClickDisaster: onClickDisaster,
    private val onClickText: onClickText
) : RecyclerView.Adapter<DisasterAdaptor.ItemDisasterViewHolder>() {

    inner class ItemDisasterViewHolder(private val binding: ItemDisasterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                onClickDisaster(listDisaster[adapterPosition])
            }

            binding.txtDisasterName.setOnClickListener {
                onClickText(listDisaster[adapterPosition])
            }

            binding.txtDisasterType.setOnClickListener {
                onClickText(listDisaster[adapterPosition])
            }
        }

        fun bind(data: Disaster) {
            with(binding) {
                txtDisasterName.text = data.nameDisaster
                txtDisasterType.text = data.typeDisaster
                imgDisaster.setImageResource(getImageResource(data.nameDisaster))
            }
        }

        private fun getImageResource(nameDisaster: String): Int {
            return when (nameDisaster) {
                "Bobby" -> R.drawable.d
                "DreamLife" -> R.drawable.e
                "Closure" -> R.drawable.f
                "Bokuno" -> R.drawable.g
                "MyTotoro" -> R.drawable.h
                "HeroAcademia" -> R.drawable.i
                else -> R.drawable.j
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemDisasterViewHolder {
        val binding = ItemDisasterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemDisasterViewHolder(binding)
    }

    override fun getItemCount(): Int = listDisaster.size

    override fun onBindViewHolder(holder: ItemDisasterViewHolder, position: Int) {
        holder.bind(listDisaster[position])
    }
}