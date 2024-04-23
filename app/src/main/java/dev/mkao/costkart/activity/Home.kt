package dev.mkao.costkart.activity

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.mkao.costkart.R
import dev.mkao.costkart.componets.PagerIndicator
import dev.mkao.costkart.componets.SpacerHeight
import dev.mkao.costkart.componets.sizeDp


@Composable
fun Home (notifications: Int) {
    val size = sizeDp(10.dp)
    val categoryItems = listOf(
        R.drawable.cat_1,
        R.drawable.cat_2,
        R.drawable.cat_3,
        R.drawable.cat_4,
        R.drawable.cat_1
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(
                    color = Color(0xFF008b86),
                    shape = RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp)
                )
        )
        {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.Home_Welcome),
                        color = Color.White,
                        fontSize = 20.sp
                    )
                }
                SpacerHeight(2.dp)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                )
                {
                    Text(
                        modifier = Modifier.padding(top = 15.dp),
                        text = stringResource(id = R.string.Bold_Desc_Home),
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    IconButton(
                        modifier = Modifier
                            .padding(5.dp)
                            .size(40.dp),

                        onClick = { /*TODO*/ }
                    ) {
                        Box {
                            Icon(
                                modifier = Modifier.size(35.dp),
                                imageVector = Icons.Filled.Notifications,
                                tint = Color.White,
                                contentDescription = stringResource(id = R.string.bellIcon),
                            )
                            if (notifications > 0) {
                                Box(
                                    modifier = Modifier
                                        .padding(start = 12.dp, top = 2.dp)
                                        .padding(horizontal = 8.dp)
                                        .background(shape = CircleShape, color = Color.Red),
                                    contentAlignment = Alignment.TopEnd
                                ) {
                                    Text(
                                        text = notifications.toString(),
                                        color = Color.White
                                    )
                                }
                            }
                        }
                    }
                }
                SpacerHeight(20.dp)
                SearchBar()
            }
        }

        SpacerHeight(5.dp)
        Adverts()
        SpacerHeight(5.dp)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Text(
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                text = stringResource(id = R.string.CategoriesHeadline))
            Spacer(modifier = Modifier.weight(1f))
            Text(
                fontSize = 15.sp,
                text = stringResource(id = R.string.CategoriesTag),
                color = colorResource(R.color.teal)
            )
        }
        SpacerHeight(5.dp)
        CategoriesPreview()
        SpacerHeight(5.dp)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Text(
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                text = stringResource(id = R.string.SellerHeadline))
            Spacer(modifier = Modifier.weight(1f))
            Text(
                fontSize = 15.sp,
                text = stringResource(id = R.string.CategoriesTag),
                color = colorResource(R.color.teal)
            )
        }
        SpacerHeight(5.dp)
        CategoriesPreview()
    }
}

@Composable
fun CategoriesPreview() {
    val categoryItems = listOf(
        R.drawable.cat_1,
        R.drawable.cat_2,
        R.drawable.cat_3,
        R.drawable.cat_4,
        R.drawable.cat_1
    )

    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(5.dp))
                    .background(colorResource(id = R.color.LightGrey)),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    modifier = Modifier.size(80.dp),
                    tint = colorResource(id = R.color.teal),
                    painter = painterResource(id = R.drawable.cat_4), contentDescription = null)
                Text("Parking", color = colorResource(id = R.color.teal))
            }
        }
        item {
            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(5.dp))
                    .background(colorResource(id = R.color.LightGrey)),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    modifier = Modifier.size(80.dp),
                    tint = colorResource(id = R.color.teal),
                    painter = painterResource(id = R.drawable.cat_2), contentDescription = null)
                Text("Towel", color = colorResource(id = R.color.teal))
            }
        }
        item {
            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(5.dp))
                    .background(colorResource(id = R.color.LightGrey)),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    modifier = Modifier.size(80.dp),
                    tint = colorResource(id = R.color.teal),
                    painter = painterResource(id = R.drawable.cat_3), contentDescription = null)
                Text("Wi-Fi", color = colorResource(id = R.color.teal))
            }
        }
        item {
            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(5.dp))
                    .background(colorResource(id = R.color.LightGrey)),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    modifier = Modifier.size(80.dp),
                    tint = colorResource(id = R.color.teal),
                    painter = painterResource(id = R.drawable.cat_2), contentDescription = null)
                Text("Television", color = colorResource(id = R.color.teal))
            }

        }

    }
}

@Composable
fun CategoriesBox() {
    val categoryItems = listOf(
        R.drawable.cat_1,
        R.drawable.cat_2,
        R.drawable.cat_3,
        R.drawable.cat_4,
        R.drawable.cat_1
    )

    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        item {
            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(5.dp))
                    .background(colorResource(id = R.color.LightGrey)),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    modifier = Modifier.size(80.dp),
                    tint = colorResource(id = R.color.teal),
                    painter = painterResource(id = R.drawable.cat_2), contentDescription = null)
                Text("Towel", color = colorResource(id = R.color.teal))
            }
        }
        item {
            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(5.dp))
                    .background(colorResource(id = R.color.LightGrey)),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    modifier = Modifier.size(80.dp),
                    tint = colorResource(id = R.color.teal),
                    painter = painterResource(id = R.drawable.cat_3), contentDescription = null)
                Text("Wi-Fi", color = colorResource(id = R.color.teal))
            }
        }
        item {
            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(5.dp))
                    .background(colorResource(id = R.color.LightGrey)),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    modifier = Modifier.size(80.dp),
                    tint = colorResource(id = R.color.teal),
                    painter = painterResource(id = R.drawable.cat_2), contentDescription = null)
                Text("Television", color = colorResource(id = R.color.teal))
            }

        }

    }
}
@Preview
@Composable
fun Preview3() {
    CategoriesPreview()
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Adverts() {
    val items = listOf(
        R.drawable.banner1,
        R.drawable.banner1,
        R.drawable.banner1
    )

    val pagerState = rememberPagerState(pageCount = { items.size })

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.fillMaxSize(),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.banner1),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(shape = RoundedCornerShape(8.dp))
                )
            }
            PagerIndicator(
                pagerState = pagerState,
                modifier = Modifier.align(Alignment.BottomCenter)
            )
        }
    }
}
@Preview
@Composable
fun PreviewSearch() {
    Adverts()
}


@Composable
fun SearchBar() {
    var text by remember { mutableStateOf(TextFieldValue()) }

    TextField(
        value = text,
        onValueChange = { text = it },
        placeholder = { Text(text = "Search for everything") },
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(15.dp)),
        leadingIcon = {
            Icon(
                Icons.Default.Search,
                contentDescription = "Search Icon",
                tint = colorResource(R.color.teal),
                modifier = Modifier.size(28.dp)
            )
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(
            onSearch = {
                // Handle search action
            }
        ),
        textStyle = TextStyle(fontSize = 16.sp)
    )
}


@Preview
@Composable
fun PreviewSearchBar() {
        SearchBar()
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomePreview(){
    Home(5)
}