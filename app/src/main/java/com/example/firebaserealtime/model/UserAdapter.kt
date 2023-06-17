package com.example.firebaserealtime.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.firebaserealtime.databinding.ItemLayoutBinding
import com.squareup.picasso.Picasso

class UserAdapter(val list: List<User>) : RecyclerView.Adapter<UserAdapter.Vh>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class Vh(val item: ItemLayoutBinding) : RecyclerView.ViewHolder(item.root) {

        fun bind(user: User) {
            item.apply {
                Picasso.get()
                    .load(user.photoUrl)
                    .into(img)
                nameTv.text = user.displayName
            }
        }
    }
}