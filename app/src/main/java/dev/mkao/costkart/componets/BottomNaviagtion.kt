package dev.mkao.costkart.componets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.mkao.costkart.ui.theme.teal50

@Composable
fun CostKartBottomNavigation(
    tabs: List<TabItem>,
    initialSelectedIndex: Int = 0,
    onItemClick: (Int) -> Unit
) {
    var selectedTab by remember { mutableStateOf(initialSelectedIndex) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
    ){
    NavigationBar(
        modifier = androidx.compose.ui.Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
    ) {
        tabs.forEachIndexed { index, tab ->
            NavigationBarItem(
                modifier = Modifier.background(teal50),
                icon = { Icon(imageVector = tab.icon, contentDescription = tab.title) },
                label = { Text(text = tab.title) },
                selected = selectedTab == index,
                onClick = {
                    selectedTab = index
                    onItemClick(index)
                }
            )
        }
    }
}
}

@Preview
@Composable
fun PreviewBottomNavigation() {
    val tabs = listOf(
        TabItem("Explorer", Icons.Outlined.MoreVert),
        TabItem("Cart", Icons.Outlined.ShoppingCart),
        TabItem("Wishlist", Icons.Default.FavoriteBorder),
        TabItem("MyOrder", Icons.Outlined.Info),
        TabItem("Profile", Icons.Outlined.Person)
    )
    CostKartBottomNavigation(tabs = tabs, onItemClick = {})
}
