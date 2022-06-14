package com.mandeep.github_commits_app.ScreensFragment

import android.net.DnsResolver
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.mandeep.github_commits_app.MVVM.DataObjects.CommitItem
import com.mandeep.github_commits_app.MVVM.MainRepositry
import com.mandeep.github_commits_app.MVVM.MyAdapetr
import com.mandeep.github_commits_app.MVVM.MyPagingAdapter
import com.mandeep.github_commits_app.MVVM.MyViewModel
import com.mandeep.github_commits_app.R
import com.mandeep.github_commits_app.databinding.FragmentScreen1Binding
import com.mandeep.github_commits_app.databinding.FragmentScreen2Binding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


@AndroidEntryPoint
class screen1 : Fragment() {

    lateinit var binding:FragmentScreen1Binding
    val myViewModel : MyViewModel by viewModels()

    lateinit var myPagingAdapter: MyPagingAdapter

    @Inject
    lateinit var mainRepositry: MainRepositry


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


   /*     myPagingAdapter = MyPagingAdapter(requireContext(),requireActivity())

        lifecycleScope.launch {
            myViewModel.listData.collect {
                myPagingAdapter.submitData(it)
            }
        }

        //val adapter = MyAdapetr(requireContext(),it,requireActivity())
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = myPagingAdapter*/

      /*  mainRepositry.getCommitItem().enqueue(object:Callback<List<CommitItem>>{
            override fun onResponse(call: Call<List<CommitItem>>, response: Response<List<CommitItem>>) {
                Log.d("3ufn3f",response.body()?.size.toString())
            }

            override fun onFailure(call: Call<List<CommitItem>>, t: Throwable) {
            }
        })*/
    }


}