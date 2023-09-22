package com.example.lab2

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers

import kotlinx.coroutines.launch

class CompanyViewModel : ViewModel() {
    //
   internal var companyList: List<CompanyModel> by mutableStateOf(listOf())

    // init data fetching
    init {
        fetchData()
    }

    fun fetchData() {
        Log.d(TAG, "Coroutine scope")
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = apiService.getCompanies()
                Log.d(TAG, response.toString())
                companyList = response
                Log.d(TAG, "FETCHING DATA")
            } catch (e: Exception) {
                // Handle error
                Log.e(TAG, "Failed to fetch data: ${e.message}")
            } 
        }
    }
}
