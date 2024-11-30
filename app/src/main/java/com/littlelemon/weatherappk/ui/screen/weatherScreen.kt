package com.littlelemon.weatherappk.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.littlelemon.weatherappk.ui.components.ActionBar
import com.littlelemon.weatherappk.ui.theme.ColorBackground

@Composable
fun WeatherScreen(){
    Scaffold(modifier= Modifier.fillMaxSize(),
        containerColor = ColorBackground,


    ){paddings->
        Column(modifier= Modifier
            .fillMaxSize()
            .fillMaxSize()
            .padding(paddings)
            .padding(horizontal = 24.dp, vertical = 10.dp),
            ){
            ActionBar()
        }

    }
}
