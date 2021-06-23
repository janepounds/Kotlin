package com.example.mykotlinapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.mykotlinapp.R
import com.smarteist.autoimageslider.SliderViewAdapter
import com.squareup.picasso.Picasso

class SliderAdapter(): SliderViewAdapter<SliderAdapter.MyViewHolder>() {
    private var sliderItems = ArrayList<String>()
    fun renewItems(sliderItems: ArrayList<String>){
        this.sliderItems = sliderItems
        notifyDataSetChanged()
    }

    fun addItems(sliderItem: String){
        sliderItems.add(sliderItem)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup?): MyViewHolder {
        val inflate: View = LayoutInflater.from(parent?.context).inflate(R.layout.image_holder,null)
        return MyViewHolder(inflate)
    }
    override fun onBindViewHolder(viewHolder: MyViewHolder?, position: Int) {
        if (viewHolder != null) {
            Picasso.get().load(sliderItems[position]).fit().into(viewHolder.imageView)
        }
    }

    override fun getCount(): Int {
        return sliderItems.size
    }

    inner class MyViewHolder(ItemView: View) : ViewHolder(ItemView) {
        var imageView:ImageView = ItemView.findViewById(R.id.imageSlider)

    }



}