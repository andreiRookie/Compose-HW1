package com.example.cupcake

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.cupcake.compose.CupcakeApp
import com.example.cupcake.model.OrderViewModel

class MainComposeActivity : AppCompatActivity() {

    private val sharedViewModel: OrderViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CupcakeApp(sharedViewModel = sharedViewModel)
        }
    }
}