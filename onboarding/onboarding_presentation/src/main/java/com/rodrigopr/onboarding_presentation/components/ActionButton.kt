package com.rodrigopr.onboarding_presentation.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.rodrigopr.core_ui.LocalSpacing


@Composable
fun ActionButton(
   text: String,
   onClick: () -> Unit,
   modifier: Modifier = Modifier,
   isEnable: Boolean = true,
   texStyle : TextStyle = MaterialTheme.typography.button
){
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = isEnable,
        shape = RoundedCornerShape(100.dp)
    ) {
        Text(
            text = text,
            style = texStyle,
            color = MaterialTheme.colors.onPrimary,
            modifier = Modifier.padding(LocalSpacing.current.spaceSmall)
        )
    }
}