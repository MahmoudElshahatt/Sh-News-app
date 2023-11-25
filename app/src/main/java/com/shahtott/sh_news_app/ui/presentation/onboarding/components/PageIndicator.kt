package com.shahtott.sh_news_app.ui.presentation.onboarding.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import com.shahtott.sh_news_app.ui.presentation.Dimens.IndicatorSize
import com.shahtott.sh_news_app.ui.theme.BlueGray

@Composable
fun CircularIndicators(
    modifier: Modifier = Modifier,
    size: Int,
    selectedPosition: Int,
    selectedColor: Color = MaterialTheme.colorScheme.primary,
    unselectedColor: Color = BlueGray
) {
    Row(modifier = modifier, horizontalArrangement = Arrangement.SpaceBetween) {
        repeat(size) { indicatorPosition ->
            Box(
                modifier = Modifier
                    .size(IndicatorSize)
                    .clip(CircleShape)
                    .background(
                        if (indicatorPosition == selectedPosition) selectedColor else unselectedColor
                    )
            )
        }
    }
}