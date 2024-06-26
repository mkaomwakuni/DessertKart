package dev.mkao.costkart.componets

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp


@Composable
fun SpacerWidth(
    width: Dp = 10.dp
) {
    Spacer(modifier = Modifier.width(width))
}
@Composable
fun SpacerHeight(
    height: Dp = 10.dp
){
    Spacer(modifier = Modifier.height(height))
}
@Composable
fun sizeDp(size: Dp = 10.dp): Dp {
        Spacer(modifier = Modifier.width(size))
        return size
}