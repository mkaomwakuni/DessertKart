package dev.mkao.costkart.activity

import android.annotation.SuppressLint
import androidx.compose.foundation.Canvas
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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asComposePath
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.PathParser.createPathFromPathData
import dev.mkao.costkart.R
import dev.mkao.costkart.componets.SpacerWidth


@SuppressLint("RestrictedApi")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailedItem() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        ) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                val pathData =
                    "M0,0 L0,350 Q${size.width / 2},${size.height + 200} ${size.width},350 L${size.width},0 Z"
                val path = createPathFromPathData(pathData).asComposePath()
                drawPath(
                    path = path,
                    color = Color(0xFFFFDAB9),
                    style = Fill
                )
            }

            TopAppBar(
                title = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .align(alignment = Alignment.TopCenter)
                    .padding(top = 20.dp),
                navigationIcon = {
                    IconButton(
                        modifier = Modifier
                            .padding(10.dp)
                            .background(Color.White, shape = CircleShape),
                        onClick = { /*TODO*/ }
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
                        modifier = Modifier
                            .padding(10.dp)
                            .background(Color.White, shape = CircleShape),
                        onClick = { /* Handle share action */ }
                    ) {
                        Icon(
                            Icons.Outlined.Favorite,
                            contentDescription = "Share",
                            tint = Color.Black
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
                        .align(alignment = Alignment.CenterHorizontally)
                )
            }
        }

        Row(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 5.dp, start = 10.dp, end = 10.dp)
        ) {
            repeat(3) { index ->
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .background(
                            color = if (index == 0) Color.Gray else Color.LightGray,
                            shape = CircleShape
                        )
                        .padding(horizontal = 4.dp)
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Card(
                modifier = Modifier
                    .weight(1f)
                    .shadow(elevation = 3.dp)
                    .height(70.dp),
                colors = CardDefaults.cardColors(Color.White),
                shape = RoundedCornerShape(5.dp),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier
                            .padding(end = 10.dp)
                    ) {
                        Text(text = "Customer Ratings", fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(text = "Over 50 reviews")
                    }
                    SpacerWidth(1.dp)
                    Box(
                        modifier = Modifier
                            .size(120.dp)
                            .background(Color.Transparent, shape = CircleShape)
                            .padding(5.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Star,
                            contentDescription = "Star Icon",
                            tint = Color.Yellow,
                            modifier = Modifier
                                .size(120.dp)
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
                                .padding(top = 25.dp),
                            text = "4.9",
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.End)
                    }
                }

            }
            Card(
                modifier = Modifier
                    .shadow(elevation = 3.dp)
                    .weight(1f)
                    .height(70.dp),
                colors = CardDefaults.cardColors(Color.White),
                shape = RoundedCornerShape(5.dp),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier
                            .weight(1f)
                    ) {
                        Text(
                            text = "Availability",
                            fontWeight = FontWeight.Bold
                        )
                    }
                    SpacerWidth(10.dp)
                    Box(
                        modifier = Modifier
                            .size(56.dp)
                            .offset(
                                x = 19.dp,
                                y = 16.dp
                            )
                            .background(Color.Red, shape = CircleShape),
                        contentAlignment = Alignment.BottomEnd
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.btn_2),
                            contentDescription = "Store",
                            tint = Color.White,
                            modifier = Modifier
                                .size(24.dp)
                                .offset(x = -18.dp,y = -10.dp)
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailPrev() {
    DetailedItem()
}