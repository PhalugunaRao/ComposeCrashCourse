package com.phalu.composecrashcourse.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.phalu.composecrashcourse.data.CountryInfo

@Composable
fun CountryCardWithConstrainLayout(countryInfo: CountryInfo){
    ConstraintLayout(modifier = Modifier.wrapContentHeight().fillMaxWidth().padding(2.dp)) {
     val(flag, commonName, capital) = createRefs()
        val imageResId = countryInfo.flagId
        val imagePainter: Painter = painterResource(imageResId)
        val topGuideline = createGuidelineFromTop(2.dp)
        val startGuideline =createGuidelineFromStart(2.dp)
        var topBarrier = createTopBarrier(flag)
        var startBarrier = createStartBarrier(flag)

        Image(
            painter = imagePainter,
            contentDescription = "country",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth(0.3f)
                .height(70.dp)
                .padding(2.dp)
                .constrainAs(flag){
                    top.linkTo(topGuideline)
                    start.linkTo(startGuideline)
                })

        Text(
            text = countryInfo.commonName,
            modifier = Modifier.fillMaxWidth(1.0f)
                .padding(2.dp).constrainAs(commonName){
                    top.linkTo(flag.bottom)
                    start.linkTo(startBarrier)
                    end.linkTo(flag.end)
                },
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = countryInfo.nationalCapital,
            modifier = Modifier.fillMaxWidth(1.0f)
                .padding(2.dp).constrainAs(capital){
                    start.linkTo(startBarrier)
                    top.linkTo(commonName.bottom)
                    end.linkTo(flag.end)

                },
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        )



    }

}