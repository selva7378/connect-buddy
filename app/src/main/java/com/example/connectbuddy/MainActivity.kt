package com.example.connectbuddy

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.connectbuddy.ui.theme.ContactBuddyTheme
import com.example.connectbuddy.viewmodel.MainViewModel
import com.example.connectbuddy.viewmodel.MainViewModelFactory


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModelFactory = MainViewModelFactory(application, this)
        enableEdgeToEdge()
        setContent {
            ContactBuddyTheme{
                val viewModel: MainViewModel = viewModel(factory = viewModelFactory)
                val isBookPosture by viewModel.isBookPosture.collectAsState()
                Log.i("Main Activity", "${isBookPosture}")
                ContactBuddy(
                    isBookPosture,
                    modifier = Modifier.padding()
                )
            }
        }
    }
}

