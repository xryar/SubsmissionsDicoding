package com.example.subsmissionsdicoding

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.subsmissionsdicoding.databinding.ItemRowBinding

class ListGameAdapter(private val listGame: ArrayList<Game>) : RecyclerView.Adapter<ListGameAdapter.ListViewHolder>() {


    class ListViewHolder(var binding: ItemRowBinding) : RecyclerView.ViewHolder(binding.root)

    //untuk menghubungkan layout item
    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): ListGameAdapter.ListViewHolder {
        val binding = ItemRowBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ListViewHolder(binding)
    }

    //menerapkan datasource sesuai posisinya
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listGame[position]
        holder.binding.imgItem.setImageResource(photo)
        holder.binding.tvItemName.text = name
        holder.binding.tvItemDescription.text = description
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.KEY_GAME, listGame[holder.adapterPosition])
            holder.itemView.context.startActivity(intent)
        }
    }

    //menetapkan ukuran dari jumlah data yang ingin ditampilkan.
    override fun getItemCount(): Int = listGame.size
}