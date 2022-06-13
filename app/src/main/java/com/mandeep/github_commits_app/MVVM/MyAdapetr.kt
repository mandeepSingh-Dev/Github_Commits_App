package com.mandeep.github_commits_app.MVVM

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.mandeep.github_commits_app.MVVM.DataObjects.Commit
import com.mandeep.github_commits_app.R

class MyAdapetr(val context: Context, val commit:Commit,val activity:Activity):RecyclerView.Adapter<MyAdapetr.MyViewHolder>() {

    lateinit var navController:NavController

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        navController = activity.findNavController(R.id.nav_host_fragment)

        val view =  LayoutInflater.from(context).inflate(R.layout.commit_item,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val singleCommit = commit.get(position)

        val author = singleCommit.commit.author.name
        val date = singleCommit.commit.author.date
        val sha =singleCommit.commit.tree.sha
        val message =singleCommit.commit.message

        holder.authorTextview.text = author
   //     holder.dateTextview.text = date
        holder.SHATextview.text =sha
        holder.messageTextview.text = message

        holder.itemView.setOnClickListener {
            val bundle = Bundle()

            bundle.putString("AUTHOR",author)
            bundle.putString("DATE",date)
            bundle.putString("SHA",sha)
            bundle.putString("MESSAGE",message)
            bundle.putString("TOTAL_COMMITS",commit.size.toString())

            navController.navigate(R.id.action_screen1_to_screen2,bundle)
        }

    }

    override fun getItemCount(): Int {

        return commit.size
    }

    inner class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    {
        val authorTextview = itemView.findViewById<TextView>(R.id.authorTextview)
        //val dateTextview = itemView.findViewById<TextView>(R.id.dateTextview)
        val SHATextview = itemView.findViewById<TextView>(R.id.SHATextview)
        val messageTextview = itemView.findViewById<TextView>(R.id.messageTextview)

    }
}