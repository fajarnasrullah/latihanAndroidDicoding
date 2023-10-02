 package com.jer.githubapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.activity.viewModels
import androidx.annotation.StringRes
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.jer.githubapp.data.response.ItemsItem
import com.jer.githubapp.data.response.SearchUserResponse2Item
import com.jer.githubapp.data.response.SearchUserResponseItem

import com.jer.githubapp.data.response.UserResponse
import com.jer.githubapp.data.retrofit.ApiConfig
import com.jer.githubapp.databinding.ActivityMainBinding
import com.jer.githubapp.ui.DataAdapter
import com.jer.githubapp.ui.MainViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

 class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private val mainViewModel by viewModels<MainViewModel>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        with(binding) {
            searchView.setupWithSearchBar(searchBar)
            searchView
                .editText
                .setOnEditorActionListener { textView, actionId, event ->
                    searchBar.text = searchView.text
                    searchView.hide()
                    Toast.makeText(this@MainActivity, searchView.text, Toast.LENGTH_SHORT).show()
                    false
                }
        }


//        with(binding) {
//            searchView.setupWithSearchBar(searchBar)
//            searchView
//                .editText
//                .setOnEditorActionListener { textView, actionId, event ->
//                    if (actionId == EditorInfo.IME_ACTION_SEARCH) {
//                        val query = searchBar.text.toString()
//                        mainViewModel.findUser(query)
//                        mainViewModel.findUser(username = String())
//                        return@setOnEditorActionListener true
//
//                    }
//
//                    searchBar.text = searchView.text
//                    searchView.hide()
//                    Toast.makeText(this@MainActivity, searchView.text, Toast.LENGTH_SHORT).show()
//                    false
//                }
//        }

        supportActionBar?.hide()




        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager
        val itemDecoration = DividerItemDecoration(this, layoutManager.orientation)
        binding.recyclerView.addItemDecoration(itemDecoration)

//        val mainViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(MainViewModel::class.java)
        mainViewModel.listUser.observe(this) { iniListUser ->
            setUserData(iniListUser)
        }

        mainViewModel.isLoading.observe(this) {
            showLoading(it)
        }


    }




     private fun setUserData (iniListUser: List<SearchUserResponse2Item>) {
            val adapter = DataAdapter()
//            val adapter = cobainadapter()
            adapter.submitList(iniListUser)
            binding.recyclerView.adapter = adapter



     }



     private fun showLoading(isLoading: Boolean) {
            if (isLoading) {
                binding.progressBar.visibility = View.VISIBLE
            } else {
                binding.progressBar.visibility = View.GONE
            }
        }
}
