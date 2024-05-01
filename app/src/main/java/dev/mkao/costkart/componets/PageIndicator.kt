package dev.mkao.costkart.componets

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PagerIndicator(
    pagerState: PagerState,
    modifier: Modifier = Modifier,
    activeColor: Color = Color.Black,
    inactiveColor: Color = Color.Gray,
    indicatorSize: Dp = 8.dp,
    indicatorSpacing: Dp = 8.dp
) {
    Box(modifier = modifier) {
        repeat(pagerState.pageCount) { pageIndex ->
            val color = if (pageIndex == pagerState.currentPage) activeColor else inactiveColor
            Box(
                modifier = Modifier
                    .size(indicatorSize)
                    .background(color)
                    .padding(horizontal = indicatorSpacing / 2)
            )
        }
    }
}
