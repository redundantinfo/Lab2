package com.example.lab2

import retrofit2.http.GET
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// boilerplate db/api stuff

private const val BASE_URL = "https://my-project-1608305480954-default-rtdb.europe-west1.firebasedatabase.app/"

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val apiService = retrofit.create(CompanyService::class.java)

interface CompanyService {
    @GET("/companies.json")
    suspend fun getCompanies(): List<CompanyModel>
}