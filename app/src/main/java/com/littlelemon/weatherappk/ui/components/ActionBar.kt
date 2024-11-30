package com.littlelemon.weatherappk.ui.components

import android.app.ActionBar
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.littlelemon.weatherappk.R
import com.littlelemon.weatherappk.ui.theme.ColorSurface


@Composable
fun ActionBar(modifier: Modifier =Modifier ){
    Row(modifier=modifier.fillMaxWidth() ,
        horizontalArrangement = Arrangement.SpaceBetween){
        ControlButton()
    }

}

@Composable
private fun  ControlButton(modifier:Modifier=Modifier){
    Surface(modifier=modifier.size(48.dp),
        color = ColorSurface,
        shape= CircleShape
        ){
        Box(modifier=Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
        ){
            Image(painter = painterResource(R.drawable.ic_control), contentDescription = null,modifier=Modifier.size(20.dp))
        }
    }
}