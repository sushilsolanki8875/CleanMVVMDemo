package com.example.cleanmvvmapp.presentation.core

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cleanmvvmapp.presentation.utils.Screens
import com.example.cleanmvvmapp.presentation.coin_list.ui.CoinListScreen
import com.example.cleanmvvmapp.presentation.theme.CleanMVVMAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CleanMVVMAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navigation = rememberNavController()
                    NavHost(navController = navigation, startDestination = Screens.CoinListScreen.route){

                        composable(Screens.CoinListScreen.route){
                            CoinListScreen()
                        }
                    }
                }
            }
        }
    }
}
