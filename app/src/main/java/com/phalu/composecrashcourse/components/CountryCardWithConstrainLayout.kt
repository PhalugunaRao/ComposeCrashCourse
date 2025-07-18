package com.phalu.composecrashcourse.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import com.phalu.composecrashcourse.data.CountryInfo

@Composable
fun CountryCardWithConstrainLayout(countryInfo: CountryInfo){
    ConstraintLayout(modifier = Modifier.wrapContentHeight().fillMaxWidth().padding(2.dp)) {
     val(flag, commonName, capital,officialName, region, subregion, currencySymbol, currencyName, mobileCode, tld) = createRefs()
        val imageResId = countryInfo.flagId
        val imagePainter: Painter = painterResource(imageResId)

        Image(
            painter = imagePainter,
            contentDescription = "country",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth(0.35f)
                .height(70.dp)
                .padding(2.dp)
                .constrainAs(flag){
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)

                })

        Text(
            text = countryInfo.commonName,
            modifier = Modifier.fillMaxWidth()
                .padding(2.dp).constrainAs(commonName){
                    start.linkTo(parent.start)
                    end.linkTo(flag.end)
                    top.linkTo(flag.bottom)

                },
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = countryInfo.nationalCapital,
            modifier = Modifier.fillMaxWidth()
                .padding(2.dp).constrainAs(capital){
                    start.linkTo(parent.start)
                    end.linkTo(flag.end)
                    top.linkTo(commonName.bottom)
                },
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = countryInfo.officialName,
            modifier = Modifier.fillMaxWidth(0.65f)
                .padding(2.dp).constrainAs(officialName){
                    top.linkTo(parent.top)
                    start.linkTo(flag.end)
                    end.linkTo(parent.end)
                },
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = countryInfo.region,
            modifier = Modifier.fillMaxWidth(1.0f)
                .padding(2.dp).constrainAs(region){
                    top.linkTo(officialName.bottom)
                    start.linkTo(flag.end)
                    end.linkTo(parent.end)
                },
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = countryInfo.subRegion,
            modifier = Modifier.fillMaxWidth(1.0f)
                .padding(2.dp).constrainAs(subregion){
                    top.linkTo(region.bottom)
                    start.linkTo(officialName.start)
                    end.linkTo(officialName.end)
                },
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        )
        CirculerText(text = countryInfo.currencySymbol,
            modifier = Modifier.constrainAs(currencySymbol){
                start.linkTo(flag.end, margin = 30.dp)
                bottom.linkTo(parent.bottom, margin = 8.dp)
            })
        Text(
            text = countryInfo.currencyName,
            modifier = Modifier.fillMaxWidth()
                .padding(2.dp).constrainAs(currencyName){
                    top.linkTo(subregion.bottom)
                    start.linkTo(currencySymbol.end)
                    bottom.linkTo(parent.bottom)
                    end.linkTo(mobileCode.start)
                },
            textAlign = TextAlign.Center
        )
        Text(
            text = countryInfo.mobileCode,
            modifier = Modifier
                .padding(2.dp)
                .constrainAs(mobileCode){
                    top.linkTo(subregion.bottom)
                    end.linkTo(parent.end)
                }.width(50.dp),
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = countryInfo.tld,
            modifier = Modifier
                .padding(2.dp).constrainAs(tld){
                    top.linkTo(mobileCode.bottom)
                    end.linkTo(parent.end)
                }.width(50.dp),
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        )




    }

}