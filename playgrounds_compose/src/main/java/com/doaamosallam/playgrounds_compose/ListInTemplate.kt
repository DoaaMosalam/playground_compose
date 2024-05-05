package com.doaamosallam.playgrounds_compose

import android.util.Log
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun ListInTemplate(
    items: List<ListItem>
) {
    val config = LocalConfiguration.current
    val scope = rememberCoroutineScope()
    var isDraggedUp by remember {
        mutableStateOf(false)
    }
    var selectedName by remember {
        mutableStateOf("Suite Shite yellow")
    }
    var price by remember {
        mutableIntStateOf(10)
    }
    val state = rememberListState(items.toTypedArray())

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp)
        ) {
            AnimatedContent(
                modifier = Modifier.weight(1f),
                targetState = selectedName,
                transitionSpec = {
                    slideInHorizontally { -it } + scaleIn() togetherWith slideOutHorizontally { it / 3 } + scaleOut()
                }
            ) { text ->
                Text(
                    text = text,
                    fontSize = 32.sp,
                    fontFamily = latinFamily,
                    fontWeight = FontWeight.SemiBold
                )
            }

            AnimatedContent(
                targetState = price,
                transitionSpec = {
                    if (targetState > initialState) {
                        slideInVertically { height -> height } + fadeIn() togetherWith
                                slideOutVertically { height -> -height } + fadeOut()
                    } else {
                        slideInVertically { height -> -height } + fadeIn() togetherWith
                                slideOutVertically { height -> height } + fadeOut()
                    }.using(
                        SizeTransform(clip = false)
                    )
                }
            ) { targetCount ->
                Text(
                    text = "${targetCount} EG",
                    fontSize = 24.sp,
                    fontFamily = latinFamily,
                    fontWeight = FontWeight.Bold
                )
            }


        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectDragGestures(
                    onDragEnd = {
                        val orderedItems = state.listItem.sortedBy { it.order }
                        Log.e(
                            "items",
                            orderedItems
                                .map { it.name }
                                .toString()
                        )
                        orderedItems.mapIndexed { index, listItem ->
                            scope.launch {
                                val nextIndex = if (isDraggedUp) {
                                    if (index == 0) 4 else (index - 1)
                                } else {
                                    if (index == 4) 0 else index + 1
                                }
                                if (nextIndex == 0) {
                                    selectedName = listItem.name
                                    scope.launch {
                                        price = listItem.price
                                    }
                                }
                                listItem.apply {
                                    launch {
                                        size.animateTo(
                                            targetValue = statelessValues[nextIndex].size.value,
                                            animationSpec = tween(durationMillis = 1500)
                                        )
                                    }
                                    launch {
                                        verticalPercentage.animateTo(
                                            targetValue = statelessValues[nextIndex].verticalPercentage.value,
                                            animationSpec = tween(durationMillis = 1500)
                                        )
                                    }
                                    launch {
                                        horizontalOffset.animateTo(
                                            targetValue = statelessValues[nextIndex].horizontalOffset.value,
                                            animationSpec = tween(durationMillis = 1500)
                                        )
                                    }
                                    launch {
                                        delay(600)
                                        blur.animateTo(
                                            targetValue = statelessValues[nextIndex].blur.value,
                                            animationSpec = tween(1500),
                                        )
                                    }
                                }
                                listItem.order = nextIndex
                            }
                        }
                    }
                ) { change, dragAmount ->
                    isDraggedUp = dragAmount.y > 0
                }
            }

    ) {
        state.listItem.forEachIndexed { index, listItem ->
            Image(
                modifier = Modifier
                    .height(listItem.size.value.dp)
                    .graphicsLayer {
                        val screenWidth = config.screenWidthDp.dp.toPx()
                        val screenHeight = config.screenHeightDp.dp.toPx()
                        translationX = screenWidth * listItem.horizontalOffset.value
                        translationY = screenHeight / 3 * listItem.verticalPercentage.value
                    }
                    .zIndex(listItem.blur.targetValue.times(-1))
                    .blur(listItem.blur.targetValue.dp),
                painter = painterResource(id = listItem.resource!!),
                contentDescription = "clothes",
                contentScale = ContentScale.FillHeight
            )
        }
    }
}


val statelessValues = listOf(
    ListItem(
        0,
        0.9f,
        -0.1f,
        600,
        0f,
        10f
    ), ListItem(
        1,
        0.4f,
        0.2f,
        400,
        1.5f,
        9f
    ),
    ListItem(
        2,
        0.2f,
        0.2f,
        200,
        3f,
        8f
    ),
    ListItem(
        3,
        0f,
        0f,
        0,
        3f,
        0f
    ),
    ListItem(
        4,
        4f,
        -1f,
        0,
        0f,
        0f
    ),
    ListItem(
        5,
        4f,
        -1f,
        0,
        0f,
        0f
    )

)


