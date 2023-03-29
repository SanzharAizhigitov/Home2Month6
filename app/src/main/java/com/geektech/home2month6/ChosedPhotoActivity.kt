package com.geektech.home2month6

import android.net.Uri
import android.view.LayoutInflater
import androidx.recyclerview.widget.GridLayoutManager
import com.geektech.home2month6.adapter.SelectedAdapter
import com.geektech.home2month6.databinding.ActivityChosedPhotoBinding

class ChosedPhotoActivity : BaseActicvity<ActivityChosedPhotoBinding>() {
    private val adapter = SelectedAdapter()

    override fun inflateVB(inflater: LayoutInflater): ActivityChosedPhotoBinding {
        return ActivityChosedPhotoBinding.inflate(inflater)
    }

    override fun initListener() {
        val uri: ArrayList<Uri>? = intent.getParcelableArrayListExtra(MainActivity.IMAGE_KEY)
        if (uri != null) {
            adapter.addImage(uri)
        }
    }

    override fun initView() {
        binding.selectedRecycler.layoutManager = GridLayoutManager(this@ChosedPhotoActivity, 3)
        binding.selectedRecycler.adapter = adapter
    }
}