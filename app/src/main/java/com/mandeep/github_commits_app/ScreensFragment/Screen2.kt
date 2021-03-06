package com.mandeep.github_commits_app.ScreensFragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.mandeep.github_commits_app.MVVM.DataObjects.CommitItem
import com.mandeep.github_commits_app.MVVM.MainRepositry
import com.mandeep.github_commits_app.MVVM.MyAdapetr
import com.mandeep.github_commits_app.R
import com.mandeep.github_commits_app.databinding.FragmentScreen2Binding
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.time.Instant
import javax.inject.Inject


@AndroidEntryPoint
class Screen2 : Fragment() {

    lateinit var binding: FragmentScreen2Binding

    @Inject
    lateinit var mainRepositry: MainRepositry

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentScreen2Binding.inflate(LayoutInflater.from(requireContext()))

        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(arguments!=null)
        {
            val author = arguments?.getString("AUTHOR")
            val date = arguments?.getString("DATE")
            val sha = arguments?.getString("SHA")
            val message = arguments?.getString("MESSAGE")
            val totalcommits = arguments?.getString("TOTAL_COMMITS")

            val authorUsername = arguments?.getString("AUTHOR_USERNAME")

          val commitsfAutor =  mainRepositry.getCommitsOfAuthor(authorUsername.toString())

            commitsfAutor.enqueue(object:Callback<List<CommitItem>>{
                override fun onResponse(call: Call<List<CommitItem>>, response: Response<List<CommitItem>>) {

                    response.body()?.let {
                        binding.totalCommitsAuthor.text = "Total number of commits of $author in this repo: ${it.size}"

                        val adapter = MyAdapetr(requireContext(), it, requireActivity())
                        val linearLayoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
                        binding.recyclervieeew.layoutManager = linearLayoutManager
                        binding.recyclervieeew.adapter = adapter
                    }
                }
                override fun onFailure(call: Call<List<CommitItem>>, t: Throwable) {
                }
            })



            binding.authorTextview2.text = author
            binding.dateTextview2.text = "Date: $date"
            binding.SHATextview2.text = "SHA: ${reduce_string(sha.toString())}"
            binding.messageTextview2.text = "Message: $message"
        }


    }

    fun reduce_string(shaString:String):String{

        return  shaString.replaceRange(8,shaString.length-1,"")
    }

    /*fun foramtDate(date:String){


    }*/
}