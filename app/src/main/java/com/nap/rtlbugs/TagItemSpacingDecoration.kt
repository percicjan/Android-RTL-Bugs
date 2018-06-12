package com.nap.rtlbugs

import android.content.Context
import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

class TagItemSpacingDecoration(context: Context) : RecyclerView.ItemDecoration() {


    private val spacing: Int = context.resources.getDimension(R.dimen.spacing_double).toInt()


    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State?) {
        val position = parent.getChildAdapterPosition(view)
        // No start & end available for Rect which breaks in RTL
        when (position) {
            0 -> {
                outRect.left = 0
                outRect.right = spacing
            }
            parent.adapter.itemCount - 1 -> {
                outRect.left = spacing
                outRect.right = 0
            }
            else -> {
                outRect.left = spacing
                outRect.right = spacing
            }
        }
    }
}