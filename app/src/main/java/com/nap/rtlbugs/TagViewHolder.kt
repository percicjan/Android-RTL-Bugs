package com.nap.rtlbugs

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView

class TagViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var tagTextView: TextView = itemView.findViewById(R.id.tag_text_view)

}
