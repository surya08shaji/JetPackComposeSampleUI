package com.example.jpe4

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun MainPage() {

    Column {
        Toolbar()
        Header()
        MenuOptionList()
        BannerList()
        ShowBoldText(text = "Popular this week")
        BottomItemList()
    }

}

@Composable
fun BottomItemList() {
    val scrollState = rememberScrollState()
    Row(modifier = Modifier.padding(top = 30.dp, start = 10.dp, bottom = 40.dp) .horizontalScroll(scrollState)) {
        BottomItem(image = R.drawable.ba1)
        BottomItem(image = R.drawable.background_two)
        BottomItem(image = R.drawable.background_one)
        BottomItem(image = R.drawable.background_three)
    }
}

@Composable
fun BottomItem(image: Int) {
    Card(
        modifier = Modifier
            .height(200.dp)
            .width(110.dp)
            .padding(start = 10.dp, end = 20.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Image(painterResource(id = image), contentDescription = ""
            , Modifier.width(300.dp), contentScale = ContentScale.Crop
        )

    }
}


@Composable
fun ShowBoldText(text: String) {
    Text(
        text = text,
        color = Color.Black,
        fontFamily = FontFamily.Default,
        style = MaterialTheme.typography.h5,
        modifier = Modifier.padding(top = 30.dp, start = 20.dp)
    )
}

@Composable
fun BannerList() {
    val scrollState = rememberScrollState()
    Row(modifier = Modifier.padding(top = 30.dp, start = 10.dp) .horizontalScroll(scrollState)) {
        BannerItem(image = R.drawable.bg2)
        BannerItem(image = R.drawable.bg1)
        BannerItem(image = R.drawable.bg2)
    }
}

@Composable
fun BannerItem(image: Int) {
    Card(
        modifier = Modifier
            .height(180.dp)
            .padding(start = 10.dp, end = 20.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Image(
            painterResource(id = image), contentDescription = "",
        )
    }
}

@Composable
fun MenuOptionList() {
    val scrollState = rememberScrollState()
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .horizontalScroll(scrollState)
            .padding(start = 20.dp, end = 20.dp, top = 40.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        MenuOptionItem(image = R.drawable.salad)
        MenuOptionItem(image = R.drawable.burger)
        MenuOptionItem(image = R.drawable.pizza)
        MenuOptionItem(image = R.drawable.fries)
    }
}

@Composable
fun MenuOptionItem(image: Int) {
    var selectedItem by remember {
        mutableStateOf(-1)
    }
    Box(
        Modifier
            .padding(20.dp)
            .clip(shape = RoundedCornerShape(8.dp))

            .background( if (selectedItem == image) Color(0.918f, 0.804f, 0.941f, 0.98f)
            else Color(1.0f, 1.0f, 1.0f, 1.0f)
            )

            .selectable(
                selected = selectedItem == image,
                onClick = {
                    selectedItem = if (selectedItem != image) image
                    else -1
                }
            )

    ) {
        Image(
            painterResource(id = image), contentDescription = "",
            modifier = Modifier.padding(8.dp).size(width = 50.dp, height = 50.dp)
        )
    }
}


@Composable
fun Header() {
    Column {
        ShowBoldText(text = "The main Food")
        Text(
            text = "12 menu", color = Color.Black,
            fontFamily = FontFamily.Default,
            style = TextStyle(fontWeight = FontWeight.Normal),
            modifier = Modifier.padding(top = 10.dp, start = 25.dp)
        )
    }
}

@Composable
fun Toolbar() {
    Row(
        modifier = Modifier
            .padding(start = 20.dp, top = 20.dp, end = 20.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painterResource(id = R.drawable.ic_baseline_keyboard_backspace_24),
            contentDescription = ""
        )

        Image(
            painter = painterResource(id = R.drawable.menu), contentDescription = "",
            modifier = Modifier
                .width(30.dp)
                .height(30.dp)
        )
    }
}

