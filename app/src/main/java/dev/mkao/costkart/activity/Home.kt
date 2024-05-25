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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
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
                    color = Color(0xFFFFDAB9),
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

        SpacerHeight(2.dp)
        Adverts()
        SpacerHeight(2.dp)
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
                color = colorResource(R.color.orange100)
            )
        }
        SpacerHeight(2.dp)
        CategoriesPreview()
        SpacerHeight(2.dp)
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
                color = colorResource(R.color.orange100)
            )
        }
        SpacerHeight(5.dp)
        CategoriesBox()
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
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        item {
            Column(
                modifier = Modifier.padding(vertical = 8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                        .background(colorResource(id = R.color.LightGrey)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        modifier = Modifier.size(60.dp),
                        tint = colorResource(id = R.color.orange100),
                        painter = painterResource(id = R.drawable.cat_4), contentDescription = null
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Bird",
                    color = Color.Black
                )
            }
        }
        item {
                Column(
                    modifier = Modifier.padding(vertical = 8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Box(
                        modifier = Modifier
                            .size(80.dp)
                            .clip(CircleShape)
                            .background(colorResource(id = R.color.LightGrey)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.cat_2),
                            contentDescription = null,
                            modifier = Modifier.size(60.dp),
                            tint = colorResource(id = R.color.orange100)
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Towel",
                        color = Color.Black
                    )
                }
        }
        item {
            Column(
                modifier = Modifier.padding(vertical = 8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                        .background(colorResource(id = R.color.LightGrey)),
                    contentAlignment = Alignment.Center
                ) {
                Icon(
                    modifier = Modifier.size(60.dp),
                    tint = colorResource(id = R.color.orange100),
                    painter = painterResource(id = R.drawable.cat_3), contentDescription = null)
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Fish",
                color = Color.Black
            )
        }
            }
        item {
            Column(
                modifier = Modifier.padding(vertical = 8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                        .background(colorResource(id = R.color.LightGrey)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        modifier = Modifier.size(60.dp),
                        tint = colorResource(id = R.color.orange100),
                        painter = painterResource(id = R.drawable.cat_2), contentDescription = null
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Dog",
                    color = Color.Black
                )
            }

        }

    }
}

@Composable
fun ImageFetcher(image: Painter) {
    Image(
        modifier = Modifier
            .height(140.dp)
            .width(140.dp)
            .clip(RoundedCornerShape(5.dp)),
        painter = image,
        contentScale = ContentScale.FillBounds,
        contentDescription = "Image"
    )
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
        modifier = Modifier
            .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween) {
        item {
            Box(modifier = Modifier
                .width(140.dp)
                .padding(5.dp)) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .width(120.dp)
                            .height(120.dp)
                            .padding(5.dp)
                            .clip(RoundedCornerShape(5.dp)),
                        contentAlignment = Alignment.BottomStart
                    ) {
                        Icon(
                            imageVector = Icons.Default.FavoriteBorder,
                            contentDescription = null,
                            tint = Color.LightGray,
                            modifier = Modifier
                                .padding(8.dp)
                                .size(20.dp)
                                .align(Alignment.TopStart)
                        )
                        ImageFetcher(image = painterResource(id = R.drawable.item1))
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            textAlign = TextAlign.Start,
                            text = "$",
                            style = TextStyle(color = Color.Gray),
                            modifier = Modifier.padding(start = 8.dp)
                        )
                        Text(
                            textAlign = TextAlign.Start,
                            text = " 250",
                            style = TextStyle(color = Color.Gray),
                            modifier = Modifier.padding(start = 8.dp)
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 10.dp),
                            horizontalArrangement = Arrangement.End
                        ) {
                            Icon(
                                imageVector = Icons.Default.Star,
                                contentDescription = null,
                                tint = Color.Yellow,
                                modifier = Modifier.size(20.dp)
                            )
                            Text(
                                text = "4.9",
                                textAlign = TextAlign.End,
                                style = TextStyle(color = Color.Black),
                                modifier = Modifier.padding(start = 4.dp)
                            )
                        }
                    }
                    SpacerHeight(5.dp)
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 5.dp),
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Text(
                            text = "Dog Sweater",
                            textAlign = TextAlign.Start,
                            fontWeight = FontWeight.Bold,
                            style = TextStyle(color = Color.Black),
                            modifier = Modifier.padding(start = 4.dp)
                        )
                    }
                }
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
                tint = colorResource(R.color.orange100),
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
        textStyle = TextStyle(fontSize = 16.sp),
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        )
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