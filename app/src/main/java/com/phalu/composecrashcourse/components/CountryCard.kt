package com.phalu.composecrashcourse.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.phalu.composecrashcourse.R
import com.phalu.composecrashcourse.data.CountryInfo

@Composable
fun CountryCard(countryInfo: CountryInfo) {
    Surface(
        modifier = Modifier
            .fillMaxWidth(1.0f)
            .padding(10.dp, 50.dp, 10.dp, 10.dp)
            .wrapContentHeight(align = Alignment.Top)
            .border(1.dp, Color.LightGray),
        shadowElevation = 2.dp
    ) {

        Row(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.2f)
                    .weight(0.2f)
            ) {
                Box(
                    modifier = Modifier
                        .width(100.dp)
                        .height(80.dp)
                        .padding(2.dp),
                    contentAlignment = Alignment.Center
                ) {
                    val imageResId = countryInfo.flagId
                    val imagePainter: Painter = painterResource(imageResId)

                    Image(
                        painter = imagePainter,
                        contentDescription = "country",
                        contentScale = ContentScale.Crop
                    )
                }
                Text(
                    text = countryInfo.commonName,
                    modifier = Modifier.fillMaxWidth(1.0f).padding(2.dp),
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = countryInfo.nationalCapital,
                    modifier = Modifier.fillMaxWidth(1.0f).padding(2.dp),
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center
                )

            }
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .weight(0.8f)
            ) {
                Text(
                    text = countryInfo.officialName,
                    modifier = Modifier.fillMaxWidth(1.0f).padding(2.dp),
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = countryInfo.region,
                    modifier = Modifier.fillMaxWidth(1.0f).padding(2.dp),
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = countryInfo.subRegion,
                    modifier = Modifier.fillMaxWidth(1.0f).padding(2.dp),
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center
                )
                Row(
                    modifier = Modifier.fillMaxWidth(1.0f),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    CirculerText(countryInfo.currencySymbol)
                    Text(
                        text = countryInfo.currencyName,
                        modifier = Modifier.fillMaxWidth(0.4f).padding(2.dp),
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center
                    )
                    Column(modifier = Modifier.fillMaxWidth(0.3f)) {
                        Text(
                            text = countryInfo.mobileCode,
                            modifier = Modifier,
                            fontSize = 18.sp,
                            textAlign = TextAlign.Center
                        )
                        Text(
                            text = countryInfo.tld,
                            modifier = Modifier,
                            fontSize = 18.sp,
                            textAlign = TextAlign.Center
                        )

                    }


                }


            }
        }


    }
}