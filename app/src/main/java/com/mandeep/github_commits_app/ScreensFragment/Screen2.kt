package com.mandeep.github_commits_app.ScreensFragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mandeep.github_commits_app.R
import com.mandeep.github_commits_app.databinding.FragmentScreen2Binding


class Screen2 : Fragment() {

    lateinit var binding: FragmentScreen2Binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentScreen2Binding.inflate(LayoutInflater.from(requireContext()))

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(arguments!=null)
        {
            val author = arguments?.getString("AUTHOR")
            val date = arguments?.getString("DATE")
            val sha = arguments?.getString("SHA")
            val message = arguments?.getString("MESSAGE")
            val totalcommits = arguments?.getString("TOTAL_COMMITS")

            binding.authorTextview2.text = author
            binding.dateTextview2.text = author
            binding.SHATextview2.text = author
            binding.messageTextview2.text = author
            binding..text = author


        }
    }


}