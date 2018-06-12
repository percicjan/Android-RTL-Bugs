package com.nap.rtlbugs

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

class TagAdapter : RecyclerView.Adapter<TagViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagViewHolder {
        return TagViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.viewtag_tag_item, parent, false))
    }


    override fun onBindViewHolder(holder: TagViewHolder, position: Int) {
        holder.tagTextView.text = position.toString()
    }


    override fun getItemCount(): Int {
        return 20
    }
}
