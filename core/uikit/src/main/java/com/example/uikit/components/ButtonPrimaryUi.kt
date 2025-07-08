package com.example.uikit.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalProvider
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.theme.MoviesTheme

@Composable
fun ButtonPrimaryUi(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    @DrawableRes icon: Int? = null
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .border(
                width = 1.dp,
                color = MoviesTheme.color.orange100,
                shape = MoviesTheme.shapes.smallRounded
            )
            .background(
                shape = MoviesTheme.shapes.smallRounded,
                color = Color.Transparent
            ),
        shape = MoviesTheme.shapes.smallRounded,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = MoviesTheme.color.orange200
        )
    ) {
        icon?.let {
            Icon(
                painter = painterResource(it),
                contentDescription = stringResource(id = R.string.icon_description),
                modifier = Modifier.width(16.dp)
            )
            Spacer(Modifier.width(8.dp))
        }
        Text(text = "teste", style = MoviesTheme.textStyle.base, color = MoviesTheme.color.grayScaleBase)
    }
}


@Preview
@Composable
private fun PreviewButtonUi() {
    ButtonPrimaryUi(onClick = {}, modifier = Modifier.fillMaxWidth(),
        icon = R.drawable.ic_launcher_background)
}