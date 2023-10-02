package com.jer.githubapp.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jer.githubapp.MainActivity
import com.jer.githubapp.data.response.ItemsItem
import com.jer.githubapp.data.response.SearchUserResponse
import com.jer.githubapp.data.response.SearchUserResponse2
import com.jer.githubapp.data.response.SearchUserResponse2Item
import com.jer.githubapp.data.response.SearchUserResponseItem
import com.jer.githubapp.data.response.UserResponse
import com.jer.githubapp.data.response.UserResponse2
import com.jer.githubapp.data.retrofit.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel: ViewModel() {


    private val _listUser = MutableLiveData<List<SearchUserResponse2Item>>()
    val listUser: LiveData<List<SearchUserResponse2Item>> = _listUser
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading
    companion object{
        private const val TAG = "MainViewModel"
//        private const val USER_ID = "fajarnasrullah"
        private const val USER_ID = "stevennathaniel"
    }

    init {
        findUser(username = USER_ID)
    }

    fun findUser(username: String) {
        Log.d("SearchQuery", "Search Query: $username")
        _isLoading.value = true
        val client = ApiConfig.getApiService().getUsers(username)
        client.enqueue(object : Callback<SearchUserResponse2> {
            override fun onResponse(
                call: Call<SearchUserResponse2>,
                response: Response<SearchUserResponse2>
            ) {
                _isLoading.value = false
                if (response.isSuccessful) {
//                    val responseBody = response.body()
//                    if (responseBody != null) {}

                    _listUser.value = response.body()?.searchUserResponse2

                } else {
                    Log.e(TAG,"onFailure: ${response.message()}")
                }
            }
            override fun onFailure(call: Call<SearchUserResponse2>, t: Throwable) {
                _isLoading.value = false
                Log.e(TAG, "onFailure: ${t.message}")
            }
        })
    }

}