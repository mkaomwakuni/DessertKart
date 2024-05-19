package dev.mkao.costkart.activity

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
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
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asComposePath
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.PathParser
import dev.mkao.costkart.R
import dev.mkao.costkart.componets.SpacerHeight
import dev.mkao.costkart.componets.SpacerWidth

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailedItem() {
    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .background(Color.Transparent)
        ) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                val pathData =
                    "M0,0 L0,350 Q${size.width / 2},${size.height + 200} ${size.width},350 L${size.width},0 Z"
                val path = PathParser.createPathFromPathData(pathData).asComposePath()
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
                            Icons.Filled.Share,
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
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(1.dp)
        ) {


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                Card(
                    modifier = Modifier
                        .wrapContentWidth()
                        .height(IntrinsicSize.Min), // Ensure both cards have the same height
                    shape = RoundedCornerShape(5.dp),

                    ) {
                    Row(
                        modifier = Modifier
                            .wrapContentWidth()
                            .height(70.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(
                            modifier = Modifier
                        ) {
                            Text(text = "Customer Ratings", fontWeight = FontWeight.Bold)
                            SpacerHeight(2.dp)
                            Text(text = "Over 50 reviews")
                        }
                        Icon(
                            imageVector = Icons.Filled.Star,
                            contentDescription = "Half Star",
                            tint = Color.Yellow,
                            modifier = Modifier
                                .size(56.dp)
                                .scale(1f, 1.9f)
                        )
                    }
                }
                Spacer(modifier = Modifier.width(16.dp))
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(70.dp), // Ensure both cards have the same height
                    shape = RoundedCornerShape(5.dp),
                ) {
                    Row(
                        modifier = Modifier
                            .wrapContentWidth()
                            .padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(
                            modifier = Modifier
                        ) {
                            Text(text = "Availability", fontWeight = FontWeight.Bold)
                        }
                        SpacerWidth(10.dp)
                        Box(
                            modifier = Modifier
                                .size(36.dp)
                                .background(Color.Red, shape = CircleShape)
                                .padding(5.dp),
                            contentAlignment = Alignment.BottomEnd
                        ) {
                            Icon(
                                modifier = Modifier.size(36.dp)
                                    .scale(1f, 1.9f),
                                painter = painterResource(id = R.drawable.btn_2),
                                contentDescription = "Store",
                                tint = Color.White
                            )
                        }
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
