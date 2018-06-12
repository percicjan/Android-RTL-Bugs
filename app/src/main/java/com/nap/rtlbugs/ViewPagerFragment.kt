package com.nap.rtlbugs

import android.annotation.SuppressLint
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.viewpager_fragment.*

class ViewPagerFragment: Fragment() {

    companion object {

        private const val INDEX = "INDEX"
        fun newInstance(index: Int): ViewPagerFragment {
            val bundle = Bundle()
            bundle.putInt(INDEX, index)
            val fragment = ViewPagerFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d("ASDASDViewPagerFragment", "Creating view")
        return inflater.inflate(R.layout.viewpager_fragment, container, false)
    }


    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("ASDASDViewPagerFragment", "onViewCreated")

        val index = arguments?.getInt(INDEX) ?: 0
        fragmentTitle.text = "Fragment $index"
        container.background = ColorDrawable(ContextCompat.getColor(container.context, if(index % 2 == 0) R.color.colorAccent else R.color.colorPrimary))

    }
}