package com.jer.githubapp.data.retrofit


import com.jer.githubapp.data.response.SearchUserResponse
import com.jer.githubapp.data.response.SearchUserResponse2
import com.jer.githubapp.data.response.UserResponse
import com.jer.githubapp.data.response.UserResponse2
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @Headers("Authorization: token 12345")
    @GET("search/users")
    fun getUsers(
        @Query("q") username: String
    ) : Call<SearchUserResponse2>


}