package dev.mkao.costkart.activity

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.mkao.costkart.R
import dev.mkao.costkart.domain.CartItem

@Composable
fun MyCart(
    cartItems: List<CartItem>,
    onClearCart: () -> Unit,
    onCheckout: () -> Unit,
    onItemRemove: (CartItem) -> Unit,
    onItemCountChange: (CartItem, Int) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp, start = 10.dp, end = 10.dp)
        ) {
            Text(
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                text = "My Cart"
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                fontSize = 16.sp,
                textAlign = TextAlign.End,
                fontWeight = FontWeight.Normal,
                text = "Clear",
                modifier = Modifier.clickable { onClearCart() }
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
        ) {
            items(cartItems) { item ->
                MyCartItem(
                    cartItem = item,
                    onItemRemove = onItemRemove,
                    onItemCountChange = onItemCountChange
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Text(
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                text = "Your Order"
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Text(
                fontWeight = FontWeight.Normal,
                fontSize = 18.sp,
                text = "Products"
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                fontWeight = FontWeight.Normal,
                fontSize = 18.sp,
                text = "$ 500"
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Text(
                fontWeight = FontWeight.Normal,
                fontSize = 18.sp,
                text = "Card Discount"
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                color = Color.Red,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                text = "$ 50"
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Text(
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                text = "Total Cost"
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                modifier = Modifier.padding(top = 5.dp),
                color = Color.Red,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                text = "$ 450"
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                onClick = onCheckout,
                colors = ButtonDefaults.buttonColors(Color(0xFF008080))
            ) {
                Text(
                    fontSize = 16.sp,
                    text = "Go to checkout")
            }
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                fontSize = 16.sp,
                text = "Available delivery methods and times can be selected when placing an order",
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun MyCartItem(
    cartItem: CartItem,
    onItemRemove: (CartItem) -> Unit,
    onItemCountChange: (CartItem, Int) -> Unit
) {
    var count by remember { mutableStateOf(cartItem.count) }

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F5F5)),
        onClick = { /*TODO*/ }
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp)
            ) {
                Image(
                    modifier = Modifier
                        .size(130.dp)
                        .padding(end = 10.dp),
                    painter = painterResource(id = cartItem.imageRes),
                    contentDescription = null
                )
                Column(modifier = Modifier.weight(1f)) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 20.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            text = cartItem.title,
                            modifier = Modifier.weight(1f)
                        )
                        IconButton(
                            onClick = { onItemRemove(cartItem) },
                            modifier = Modifier.size(24.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = "Close"
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        text = cartItem.description
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            modifier = Modifier.background(color = Color.LightGray, shape = RoundedCornerShape(15.dp)),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            IconButton(onClick = { if (count > 1) count--; onItemCountChange(cartItem, count) }) {
                                Icon(
                                    imageVector = Icons.Default.ArrowDropDown,
                                    contentDescription = "Minus"
                                )
                            }
                            Divider(
                                color = Color.Black,
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .width(1.dp)
                            )
                            Text(
                                text = "$count",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(horizontal = 8.dp)
                            )
                            VerticalDivider(
                                color = Color.Black,
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .width(1.dp)
                            )
                            IconButton(onClick = { count++; onItemCountChange(cartItem, count) }) {
                                Icon(
                                    imageVector = Icons.Default.Add,
                                    contentDescription = "Plus"
                                )
                            }
                        }
                        Text(
                            text = cartItem.price,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMyCart() {
    val cartItems = listOf(
        CartItem(R.drawable.item1, "Item Title 1", "Item Description 1", "$ 50", 1),
        CartItem(R.drawable.item2, "Item Title 2", "Item Description 2", "$ 50", 1)
    )
    MyCart(
        cartItems = cartItems,
        onClearCart = {},
        onCheckout = {},
        onItemRemove = {},
        onItemCountChange = { _, _ -> }
    )
}
