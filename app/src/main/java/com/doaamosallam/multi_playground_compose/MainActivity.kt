package com.doaamosallam.multi_playground_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.doaamosallam.multi_playground_compose.ui.theme.Multi_playground_composeTheme
import com.doaamosallam.playgrounds_compose.ListInTemplate
import com.doaamosallam.playgrounds_compose.ListItem

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Multi_playground_composeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Multi_playground_composeTheme {
        Greeting("Android")
    }
}
@Preview(showBackground = true)
@Composable
private fun ClothesStorePrev() {
    // Provide a preview with dummy items
    ListInTemplate(
        items = listOf(
            ListItem(
                0,
                0.9f,
                -0.1f,
                600,
                0f,
                10f,
                "White Shoes",
                15,
                R.drawable.shoe_3
            ),
            ListItem(
                0,
                0.9f,
                -0.1f,
                600,
                0f,
                10f,
                "Yellow Swite Sirt",
                150,
                R.drawable.img_3
            ),
            ListItem(
                1,
                0.4f,
                0.1f,
                400,
                1.5f,
                9f,
                "Baby Boy",
                100,
                R.drawable.img_bayboy_switeshirt
            ),
            ListItem(
                2,
                0.2f,
                0.2f,
                200,
                3f,
                8f,
                "Blazer Man",
                1700,
                R.drawable.img_balzer_man
            ),
            ListItem(
                3,
                0f,
                0f,
                0,
                3f,
                0f,
                "Green Blouse",
                8,
                R.drawable.img_green_blouse
            ),
            ListItem(
                4,
                4f,
                -1f,
                0,
                0f,
                0f,
                "Baby Short and Shirt",
                4,
                R.drawable.img_bayboy_short_shirt
            )
        )
    )
}