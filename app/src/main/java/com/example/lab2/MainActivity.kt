package com.example.lab2

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color.DarkGray // white hurts my eyes, anything darker looks bad
            ) {
                App()
            }
        }
    }
}

// call to run
@Composable
fun App(){
    Log.d(TAG, "App function")
    // init the viewmodel
    val dbViewModel : CompanyViewModel = viewModel()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        DisplayData(dbViewModel)
    }
}

// display the stuff using lazycolumn
@Composable
fun DisplayData(dbViewModel : CompanyViewModel){
    Column(modifier = Modifier.fillMaxSize()){
        Log.d(TAG, "DisplayData function")
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.LightGray)
        ) {
            // simple way to show everything in the list of company json data
            items(
                dbViewModel.companyList
            ) { entry ->
                Column {
                    Text(text = entry.title, color = Color.Black)
                    Text(text = entry.city, color = Color.Black)
                    Text(text = entry.webpage + "\n" + "___________________", color = Color.Black)
                }
            }
        }
    }
}