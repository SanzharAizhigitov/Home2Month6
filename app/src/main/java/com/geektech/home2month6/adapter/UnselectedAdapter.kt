package com.geektech.home2month6.adapter

import android.net.Uri
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.geektech.home2month6.databinding.ItemGallerysImageBinding
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View.*
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.geektech.home2month6.R
import com.google.android.material.animation.AnimatableView.Listener

class UnselectedAdapter(private val listener: Listener):
    Adapter<UnselectedAdapter.AdapterHolder>() {

    private val imageList = arrayListOf<Uri>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_gallerys_image, parent, false)
        return AdapterHolder(view)
    }

    override fun onBindViewHolder(holder: AdapterHolder, position: Int) {
        holder.bind(imageList[position], listener)
    }

    override fun getItemCount() = imageList.size


    inner class AdapterHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = ItemGallerysImageBinding.bind(item)

        fun bind(mainImage: Uri, listener: Listener) = with(binding) {
            image.setImageURI(mainImage)
            imageShadow.visibility = INVISIBLE
            itemView.setOnClickListener {
                if (!imageShadow.isVisible) {
                    listener.onClick(mainImage)
                    imageShadow.visibility = VISIBLE
                } else {
                    listener.deleteClick(mainImage)
                    imageShadow.visibility = INVISIBLE
                }
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addImage(image: Uri) {
        this.imageList.addAll(listOf(image))
        notifyDataSetChanged()
    }

    interface Listener {
        fun onClick(mainImage: Uri)
        fun deleteClick(mainImage: Uri)
    }
}
