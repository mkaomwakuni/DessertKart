package dev.mkao.costkart.activity

import android.annotation.SuppressLint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asComposePath
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.PathParser
import dev.mkao.costkart.R
import dev.mkao.costkart.componets.SpacerHeight
import dev.mkao.costkart.componets.SpacerWidth

@SuppressLint("RestrictedApi")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailedItem() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
            .padding(10.dp)
    ) {
        TopSection()
        Spacer(modifier = Modifier.height(10.dp))
        TitleSection()
        Spacer(modifier = Modifier.height(20.dp))
        RatingAndAvailabilitySection()
        Spacer(modifier = Modifier.height(10.dp))
        CompositionSection()
        Spacer(modifier = Modifier.height(15.dp))
        DescriptionSection()
        Spacer(modifier = Modifier.height(15.dp))
        KeyFeaturesSection()
        Spacer(modifier = Modifier.height(15.dp))
        MoreInfoSection()
        Spacer(modifier = Modifier.height(10.dp))
        PriceAndAddToCartSection()
    }
}

@SuppressLint("RestrictedApi")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val pathData = "M0,0 L0,350 Q${size.width / 2},${size.height + 200} ${size.width},350 L${size.width},0 Z"
            val path = PathParser.createPathFromPathData(pathData).asComposePath()
            drawPath(path = path, color = Color(0xFFFFDAB9), style = Fill)
        }
        TopAppBar(
            title = {},
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
                .padding(top = 20.dp),
            navigationIcon = {
                IconButton(
                    onClick = { /* Handle back navigation */ },
                    modifier = Modifier
                        .padding(10.dp)
                        .background(Color.White, shape = CircleShape)
                ) {
                    Icon(
                        Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.Black
                    )
                }
            },
            actions = {
                IconButton(
                    onClick = { /* Handle favorite action */ },
                    modifier = Modifier
                        .padding(10.dp)
                        .background(Color.White, shape = CircleShape)
                ) {
                    Icon(
                        Icons.Outlined.Favorite,
                        contentDescription = "Favorite",
                        tint = Color.DarkGray
                    )
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.Transparent,
                titleContentColor = Color.Transparent,
                actionIconContentColor = Color.White
            )
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center)
        ) {
            Spacer(modifier = Modifier.height(80.dp))
            Image(
                painter = painterResource(id = R.drawable.item1),
                contentDescription = "Product Image",
                modifier = Modifier
                    .size(250.dp)
                    .align(Alignment.CenterHorizontally)
            )
        }
    }
}

@Composable
fun TitleSection() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Product Title",
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        )
    }
}

@Composable
fun RatingAndAvailabilitySection() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        RatingCard()
        AvailabilityCard()
    }
}

@Composable
fun RatingCard() {
    Card(
        modifier = Modifier
            .height(70.dp),
        colors = CardDefaults.cardColors(Color.White),
        shape = RoundedCornerShape(5.dp),
        elevation = CardDefaults.cardElevation(3.dp)
    ) {
        Row(
            modifier = Modifier
                .wrapContentWidth()
                .padding(5.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier
                .wrapContentWidth()) {
                Text(text = "Customer Ratings", fontWeight = FontWeight.Bold)
                Text(text = "Over 50 reviews")
            }
            Box(
                modifier = Modifier
                    .size(56.dp)
                    .background(Color.Transparent, shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Filled.Star,
                    contentDescription = "Star Icon",
                    tint = Color.Yellow,
                    modifier = Modifier
                        .size(40.dp)
                        .offset(
                            x = 10.dp,
                            y = 24.dp
                        )
                        .scale(4f, 4f)
                        .clip(RoundedCornerShape(8.dp))
                        .rotate(-40f)
                )
                Text(
                    modifier = Modifier
                        .padding(top = 25.dp)
                        .offset(x = 5.dp),
                    fontSize = 18.sp,
                    text = "4.9",
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun AvailabilityCard() {
    Card(
        modifier = Modifier
            .height(70.dp),
        colors = CardDefaults.cardColors(Color.White),
        shape = RoundedCornerShape(5.dp),
        elevation = CardDefaults.cardElevation(3.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Availability",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1f)
            )
            Box(
                modifier = Modifier
                    .size(56.dp)
                    .offset(
                        x = 19.dp,
                        y = 16.dp
                    )
                    .background(Color.Red, shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.btn_2),
                    contentDescription = "Store",
                    tint = Color.White,
                    modifier = Modifier
                        .size(34.dp)
                        .offset(x = -1.dp, y = -2.dp)
                        .rotate(-30f)
                )
            }
        }
    }
}

@Composable
fun CompositionSection() {
    Column {
        Text(
            text = "Product Information",
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.DarkGray
            )
        )
    }
}

@Composable
fun DescriptionSection() {
    Column {
        Text(
            text = "This is a detailed description of the product. It covers all the features and benefits of the product.",
            style = TextStyle(
                fontSize = 16.sp,
                color = Color.Gray
            )
        )
    }
}

@Composable
fun KeyFeaturesSection() {
    Column {
        Text(
            text = "Warranty",
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        )
        SpacerHeight(5.dp)
        Text(
            text = "12 months",
            style = TextStyle(
                fontSize = 16.sp,
                color = Color.Gray
            )
        )
    }
}

@Composable
fun MoreInfoSection() {
    Column {
        Text(
            text = "Similar Products",
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        )
        Spacer(modifier = Modifier.height(10.dp))
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(2) {
                MoreInfoCard()
            }
        }
    }
}


@Composable
fun MoreInfoCard() {
    Card(
        modifier = Modifier
            .width(300.dp)
            .height(100.dp),
        colors = CardDefaults.cardColors(Color.White),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(3.dp)
    ) {
        Row(
            modifier = Modifier.padding(15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .background(Color(0xFFFFDAB9), shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.item1),
                    contentDescription = "Item Image",
                    modifier = Modifier
                        .size(120.dp)
                        .scale(1.6f)
                )
            }
            SpacerWidth(10.dp)
            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(
                    text = "Product Name",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "Product Description",
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                )
                SpacerHeight(10.dp)
                Row(modifier = Modifier.fillMaxWidth()) {
                    Row(
                        modifier = Modifier
                            .background(Color(0xFFFFDAB9), shape = RoundedCornerShape(18.dp))
                            .padding(horizontal = 8.dp)
                    ) {
                        Text(
                            text = "$19.99",
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black
                            )
                        )

                        IconButton(
                            modifier = Modifier.size(25.dp),
                            onClick = { /* Handle add to cart action */ }
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Add,
                                contentDescription = "Add to Cart",
                                tint = Color.Black
                            )
                        }
                    }
                }

            }
        }
    }
}

@Composable
fun PriceAndAddToCartSection() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp),
        colors = CardDefaults.cardColors(Color.White),
        shape = RoundedCornerShape(8.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(text = "$250.99", fontWeight = FontWeight.Bold, fontSize = 24.sp)
                Text(text = "Free Shipping", fontWeight = FontWeight.Normal, fontSize = 14.sp)
            }
            TextButton(
                onClick = { /* Handle add to cart */ },
                modifier = Modifier
                    .clip(RoundedCornerShape(1.dp))
                    .background(color = Color(0xFFFFDAB9))
            ) {
                Icon(
                    Icons.Default.Add,
                    contentDescription = "Add to Cart",
                    tint = Color.Black
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = "Add to Cart",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailedItemPreview() {
    DetailedItem()
}
