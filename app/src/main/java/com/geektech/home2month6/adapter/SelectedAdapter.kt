package com.geektech.home2month6.adapter

import android.annotation.SuppressLint
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geektech.home2month6.R
import com.geektech.home2month6.databinding.SelectedGalleryBinding

class SelectedAdapter : RecyclerView.Adapter<SelectedAdapter.ImageHolder>() {

    //Переменная
    private val imageList = arrayListOf<Uri>()

    //Холдер
    class ImageHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = SelectedGalleryBinding.bind(item)
        fun bind(mainImage: Uri) = with(binding) {
            imageSelectedRecycler.setImageURI(mainImage) //Вставляем изображение
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.selected_gallery, parent, false)
        return ImageHolder(view)
    }

    override fun onBindViewHolder(holder: ImageHolder, position: Int) {
        holder.bind(imageList[position])
    }

    override fun getItemCount() = imageList.size


    @SuppressLint("NotifyDataSetChanged")
    fun addImage(mainImage: ArrayList<Uri>) {
        this.imageList.addAll(mainImage)
        notifyDataSetChanged()
    }
}