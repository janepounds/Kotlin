package com.example.mykotlinapp.adapters

import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.mykotlinapp.R
import com.example.mykotlinapp.fragments.HomeFragment
import com.smarteist.autoimageslider.SliderViewAdapter
import com.squareup.picasso.Picasso

class SliderAdapter( context: HomeFragment): SliderViewAdapter<SliderAdapter.MyViewHolder>() {
    private val TAG = "SliderAdapter"
    private var sliderItems = ArrayList<String>()
    private val context = context

    fun renewItems(sliderItems: ArrayList<String>){
        this.sliderItems = sliderItems
        notifyDataSetChanged()
    }


    fun addItem(sliderItem: String){
        sliderItems.add(sliderItem)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup?): MyViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.image_holder, parent, false)

        return MyViewHolder(view)
    }
    override fun onBindViewHolder(viewHolder: MyViewHolder?, position: Int) {
        if (viewHolder != null) {
            Glide.with(context)
                .load(sliderItems[position])
                .centerCrop()
                .error(R.drawable.slider_img_1)
                .into(viewHolder.imageView)
        }
           // Glide.with(context).load(sliderItems[position]).into(viewHolder.imageView)
//            Picasso.get().load(sliderItems[position]).fit().into(viewHolder?.imageView)

    }

    override fun getCount(): Int {
        Log.d(TAG, "getCount: "+sliderItems.size)
        return sliderItems.size
    }

    inner class MyViewHolder(ItemView: View) : ViewHolder(ItemView) {
        var imageView:ImageView = ItemView.findViewById(R.id.imageSlider)

    }



}