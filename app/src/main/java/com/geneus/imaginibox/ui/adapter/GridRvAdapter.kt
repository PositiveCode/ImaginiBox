package com.geneus.imaginibox.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geneus.imaginibox.R
import com.geneus.imaginibox.async.SetImageAsync
import jp.co.cyberagent.android.gpuimage.GPUImageView
import kotlinx.android.synthetic.main.rv_box_item.view.*

class GridRvAdapter (val context : Context, var boxCount : Int) : RecyclerView.Adapter<GridRvAdapter.MyViewHolder>(){
    private var tapCount : Int = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.rv_box_item, parent, false))
    }

    override fun getItemCount(): Int {
        return boxCount
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.givBox.setOnClickListener {
            SetImageAsync(it as GPUImageView?, context, tapCount).execute("")
            tapCount++

            if (tapCount > 4) {
                tapCount = 0
            }
        }
    }

    class MyViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        val givBox = view.givBox
    }
}