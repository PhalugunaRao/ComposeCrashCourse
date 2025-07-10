package com.phalu.composecrashcourse.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CirculerText(text:String){
    Text(
        text = text, modifier = Modifier
        .fillMaxWidth(0.1f)
        .drawBehind { drawCircle(color = Color.LightGray, radius = this.size.maxDimension) }
        .padding(2.dp),
        fontSize = 18.sp, textAlign = TextAlign.Center)

}