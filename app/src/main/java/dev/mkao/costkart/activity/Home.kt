package dev.mkao.costkart.activity

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.mkao.costkart.R
import dev.mkao.costkart.componets.SpacerHeight
import dev.mkao.costkart.componets.sizeDp


@Composable
fun Home (notifications: Int) {
    val size = sizeDp(10.dp)

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
                    .fillMaxWidth())
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
        }
    }
}
@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    onSearch:(String) -> Unit,
){

}

@Preview(showBackground = true)
@Composable
fun HomePreview(){
    Home(5)
}