package dev.mkao.costkart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dev.mkao.costkart.ui.theme.CoasterKartTheme


class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		setContent {
			CoasterKartTheme {

			}
		}
	}
}
