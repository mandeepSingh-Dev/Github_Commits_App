package com.mandeep.github_commits_app.ScreensFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.mandeep.github_commits_app.MVVM.MyAdapetr
import com.mandeep.github_commits_app.MVVM.MyViewModel
import com.mandeep.github_commits_app.R
import com.mandeep.github_commits_app.databinding.FragmentScreen1Binding
import com.mandeep.github_commits_app.databinding.FragmentScreen2Binding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class screen1 : Fragment() {

    lateinit var binding:FragmentScreen1Binding
    val myViewModel : MyViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentScreen1Binding.inflate(LayoutInflater.from(requireContext()))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myViewModel.livecommits.observe(requireActivity(), Observer {
            val adapter = MyAdapetr(requireContext(),it,requireActivity())
            binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
            binding.recyclerView.adapter =adapter
        })

    }

}