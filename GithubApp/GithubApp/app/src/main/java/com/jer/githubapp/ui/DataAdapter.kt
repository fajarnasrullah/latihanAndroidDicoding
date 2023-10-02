package com.jer.githubapp.ui

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
//import android.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.jer.githubapp.R
import com.jer.githubapp.UserDetailActivity
import com.jer.githubapp.data.response.ItemsItem
import com.jer.githubapp.data.response.SearchUserResponse2Item
import com.jer.githubapp.data.response.SearchUserResponseItem

import com.jer.githubapp.databinding.ItemListUserBinding

class DataAdapter  :  ListAdapter <SearchUserResponse2Item, DataAdapter.MyViewHolder> (DIFF_CALLBACK){
//class DataAdapter (private val mlistUser: ArrayList<>, val context: Context) : RecyclerView.Adapter<DataAdapter.MyViewHolder>(
//    DIFF_CALLBACK) {

    class MyViewHolder( val binding: ItemListUserBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(user: SearchUserResponse2Item){

            val imgPhoto: ImageView = itemView.findViewById(R.id.img_list)
            val tvName: TextView = itemView.findViewById(R.id.username_list)
//            val imgPhoto: ImageView = itemView.findViewById(R.id.img_list)
//            val tvName: TextView = itemView.findViewById(R.id.username_list)
//
//            val imgUrl = binding.imgList
            val imgUrl = user.avatarUrl
            tvName.text = user.login
            imgPhoto.setImageResource(user.id)
//
//            tvDescription.text = iniDesti.deskripsi_destinasi
//            imgPhoto.setImageResource(iniDesti.gambar_destinasi)

//            binding.usernameList.text = user.login

            Glide.with(itemView.context)
                .load(imgUrl)
                .apply(RequestOptions().override(300, 300))
                .into(imgPhoto)

//            Glide.with(itemView)
//                .load(user.avatarUrl)
//                .into(binding.imgList)

//            binding.usernameList.setOnClickListener {
//                val intent = Intent(context,UserDetailActivity::class.java)
//                intent.putExtra("nama",user.login)
//                context.startActivity(intent)
//            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_user, parent, false)
        val binding = ItemListUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
//        return MyViewHolder(view)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        holder.bind(mlistUser[position])

        val datanya = getItem(position)
        holder.bind(datanya)
    }



//    override fun getItemCount() {
//
//    }

    companion object {
//        fun submitList(itemItem: List<SearchUserResponseItem>) {
//
//        }

        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<SearchUserResponse2Item>() {
            override fun areItemsTheSame(oldItem: SearchUserResponse2Item, newItem: SearchUserResponse2Item): Boolean {
                return oldItem.id == newItem.id
            }
            override fun areContentsTheSame(oldItem: SearchUserResponse2Item, newItem: SearchUserResponse2Item): Boolean {
                return oldItem == newItem
            }
        }
    }
}

