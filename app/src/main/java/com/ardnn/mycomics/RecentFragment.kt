package com.ardnn.mycomics

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class RecentFragment : Fragment() {

    companion object {
        fun newInstance(): RecentFragment {
            val fragment = RecentFragment()
            val args = Bundle()
            fragment.arguments = args

            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recent, container, false)
    }

}