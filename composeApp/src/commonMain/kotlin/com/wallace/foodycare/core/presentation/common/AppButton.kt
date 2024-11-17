package com.wallace.foodycare.core.presentation.common

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun AppButton(
    roundedCornerShapeSize: Dp = 20.dp,
    onClick: () -> Unit,
    containerColor: Color = MaterialTheme.colorScheme.primary,
    contentColor: Color = MaterialTheme.colorScheme.onPrimary,
    borderColor: Color = containerColor,
    buttonHeight: Dp = 54.dp,
    content: @Composable () -> Unit,
    modifier: Modifier = Modifier
        .padding(vertical = 10.dp)
) {
    Button(
        onClick = onClick,
        colors = ButtonColors(
            contentColor = contentColor,
            containerColor = containerColor,
            disabledContentColor = contentColor,
            disabledContainerColor = containerColor,
        ),
        shape = RoundedCornerShape(roundedCornerShapeSize),
        modifier = modifier
            .border(width = 1.dp, borderColor, shape = RoundedCornerShape(roundedCornerShapeSize))
            .height(buttonHeight)
    ) {
        content()
    }
}