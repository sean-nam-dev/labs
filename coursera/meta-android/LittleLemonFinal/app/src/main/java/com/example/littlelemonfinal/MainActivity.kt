package com.example.littlelemonfinal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.littlelemonfinal.navigation.Destination
import com.example.littlelemonfinal.ui.theme.LittleLemonFinalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            LittleLemonFinalTheme {
                NavHost(
                    startDestination = Destination.Register,
                    navController = navController
                ) {
                    composable<Destination.Register> {

                    }
                    composable<Destination.Home> {

                    }
                    composable<Destination.LogOut> {

                    }
                }
            }
        }
    }
}