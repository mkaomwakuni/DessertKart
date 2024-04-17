package dev.mkao.costkart.activity

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.mkao.costkart.R
import dev.mkao.costkart.componets.SpacerHeight
import dev.mkao.costkart.componets.SpacerWidth

@Composable
fun Splashscreen() {

    val introText = with(AnnotatedString.Builder()) {
        pushStyle(
            style = SpanStyle(
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
        )
        append(stringResource(id = R.string.introduction_unveil))
        pushStyle(
            style = SpanStyle(
                color = Color(0xFF008b86),
                fontWeight = FontWeight.Bold
            )
        )
        append(", " + stringResource(id = R.string.introduction_for_your_pet))

        pushStyle(
            style = SpanStyle(
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
        )
        append(" " + stringResource(id = R.string.introduction_toys_accessories_foods))

        toAnnotatedString()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = Modifier) {
            Image(
                painter = painterResource(id = R.drawable.intro_logo),
                contentDescription = stringResource(id = R.string.dessert_description)
            )
        }
        SpacerHeight(16.dp)
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.introduction_unveil), style = TextStyle(
                    color = Color.Black,
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            SpacerHeight(5.dp)
            Text(
                text = AnnotatedString.Builder().apply {
                    pushStyle(
                        style = SpanStyle(
                            color = Color(0xFF008b86),
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    append(stringResource(R.string.introduction_toys_accessories_foods))
                    pushStyle(
                        style = SpanStyle(
                            color = Color.Black,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    append("\n" + stringResource(R.string.introduction_for_your_pet))
                }.toAnnotatedString(),
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    color = Color.LightGray,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            SpacerHeight(5.dp)
            Text(
                text = stringResource(R.string.SplashDescription), style = TextStyle(
                    color = Color.DarkGray,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center
                )
            )
        }
        SpacerHeight(5.dp)
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth()
                .height(60.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFF008b86))
        ) {
            Text(text = stringResource(id = R.string.SplashButtonText))
        }
    }

}

@Preview(showSystemUi = true)
@Composable
fun PreviewSplash(){
    Splashscreen()
}
