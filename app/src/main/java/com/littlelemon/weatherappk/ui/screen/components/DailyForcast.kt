package com.littlelemon.weatherappk.ui.screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.littlelemon.weatherappk.R
import com.littlelemon.weatherappk.ui.theme.ColorGradient1
import com.littlelemon.weatherappk.ui.theme.ColorGradient2
import com.littlelemon.weatherappk.ui.theme.ColorGradient3
import com.littlelemon.weatherappk.ui.theme.ColorTextSecondary
import com.littlelemon.weatherappk.ui.theme.ColorTextSecondaryVariant
import com.littlelemon.weatherappk.ui.theme.ColorWindForecast
import java.time.format.TextStyle

@Composable
fun DailyForcast(modifier: Modifier=Modifier,
                 forecast:String="Rain Shower",
                 date:String="Monday,12 Feb"
                 ){
    ConstraintLayout(modifier=modifier.fillMaxWidth())
    {
     val (forcastImage,forcastvalue,windImage,title,description,background)=createRefs()
        CardBackground(
            modifier = Modifier.constrainAs(background) {
                linkTo(
                    start = parent.start,
                    end = parent.end,
                    top = parent.top,
                    bottom = description.bottom,
                    topMargin = 24.dp
                )
                height = Dimension.fillToConstraints
            }
        )

        Image(
            painter = painterResource(R.drawable.img_sub_rain),
            contentDescription = null,
            contentScale = ContentScale.FillHeight
            ,
            modifier = Modifier
                .height(175.dp)
                .constrainAs(forcastImage)
                {
                    start.linkTo(anchor = parent.start, margin = 4.dp)
                    top.linkTo(anchor = parent.top,)
                }           )
            Text(text=forecast,
                style = MaterialTheme.typography.titleLarge,color= ColorTextSecondary, fontWeight = FontWeight.Medium,
                modifier = Modifier.constrainAs(title){
                    start.linkTo(anchor = parent.start, margin = 24.dp)
                    top.linkTo(anchor = forcastImage.bottom)

                }
                )

        Text(text=date,
            style = MaterialTheme.typography.bodyMedium ,color= ColorTextSecondaryVariant,
            modifier = Modifier
                .constrainAs(description) {
                    start.linkTo(anchor = title.start)
                    top.linkTo(anchor = title.bottom)

                }
                .padding(bottom = 24.dp)
        )
        ForecastValue(
            modifier=Modifier.constrainAs(forcastvalue)
            {
                    end.linkTo(anchor = parent.end, margin = 24.dp)
                    top.linkTo(anchor = forcastImage.top)
                    bottom.linkTo(anchor = forcastImage.bottom)
            }
        )

    }
}



@Composable
private fun CardBackground(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                brush = Brush.linearGradient(
                    0f to ColorGradient1,
                    0.5f to ColorGradient2,
                    1f to ColorGradient3
                ),
                shape = RoundedCornerShape(32.dp)
            )
    )
}
@Composable
private fun ForecastValue(
    modifier: Modifier = Modifier,
    degree: String = "21",
    description: String = "Feels like 26°"
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start
    ) {
        Box(
            contentAlignment = Alignment.TopEnd
        ) {
            Text(
                text = degree,
                letterSpacing = 0.sp,
                style = androidx.compose.ui.text.TextStyle(
                    brush = Brush.verticalGradient(
                        0f to Color.White,
                        1f to Color.White.copy(alpha = 0.3f)
                    ),
                    fontSize = 80.sp,
                    fontWeight = FontWeight.Black
                ),
                modifier = Modifier.padding(end = 16.dp)
            )
            Text(
                text = "°",
                style = androidx.compose.ui.text.TextStyle(
                    brush = Brush.verticalGradient(
                        0f to Color.White,
                        1f to Color.White.copy(alpha = 0.3f)
                    ),
                    fontSize = 70.sp,
                    fontWeight = FontWeight.Light,
                ),
                modifier = Modifier.padding(top = 2.dp)
            )
        }
        Text(
            text = description,
            style = MaterialTheme.typography.bodyMedium,
            color = ColorTextSecondaryVariant
        )
    }
}

@Composable
private fun WindForecastImage(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_frosty),
            contentDescription = null,
            modifier = Modifier.size(60.dp),
            tint = ColorWindForecast
        )
        Icon(
            painter = painterResource(R.drawable.ic_wind),
            contentDescription = null,
            modifier = Modifier.size(60.dp),
            tint = ColorWindForecast
        )
    }
}