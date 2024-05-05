package com.doaamosallam.playgrounds_compose

import androidx.annotation.DrawableRes
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.VectorConverter
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.font.FontFamily

@Composable
fun rememberListState(
    items: Array<ListItem>,
) = remember {
    ClothesStoreState(items)
}

class ClothesStoreState(
    items: Array<ListItem>,
) {
    var listItem = mutableStateListOf(*items)
}
//
class ListItem(
    order: Int,
    verticalPercentage: Float,
    horizontalOffset: Float,
    size: Int,
    blur: Float,
    zIndex: Float,
    val name: String = "",
    val price: Int = 0,
    @DrawableRes val resource: Int? = null
) {
    var order by mutableIntStateOf(order)
    var verticalPercentage = Animatable(verticalPercentage)
    var horizontalOffset = Animatable(horizontalOffset)
    var size = Animatable(size, Int.VectorConverter)
    var blur = Animatable(blur)
    var zIndex by mutableFloatStateOf(zIndex)
}
val latinFamily = FontFamily.Default