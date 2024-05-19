package dev.mkao.costkart.domain
data class CartItem(
    val imageRes: Int,
    val title: String,
    val description: String,
    val price: String,
    val count: Int
)