package com.example.animes.presentation.signin

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.animes.R

@Composable
fun SignIn(
    uiState: SignInUiState,
    onSignIn: () -> Unit,
    navigateToSignUp: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
    ) {

        AnimatedVisibility(visible = uiState.error != null) {
            Box(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.error)
                    .fillMaxWidth()
            ) {
                Text(
                    text = uiState.error ?: "", fontSize = 20.sp, modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )

            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(MaterialTheme.colorScheme.primary)
                .padding(24.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Login", fontSize = 20.sp)
            TextField(
                label = { Text("email") },
                leadingIcon = {
                    Icon(
                        Icons.Default.Email,
                        contentDescription = stringResource(id = R.string.email_icon)
                    )
                },
                value = uiState.email,
                onValueChange = uiState.onChangeEmail,
                textStyle = TextStyle(color = Color.Gray),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 8.dp)
            )
            TextField(
                label = { Text("password") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Password,
                        contentDescription = stringResource(id = R.string.password_icon)
                    )
                },
                value = uiState.password,
                onValueChange = { uiState.onChangePassword(it) },
                textStyle = TextStyle(color = Color.Gray),
                trailingIcon = {
                    val trailingIconModifier = Modifier
                        .clip(CircleShape)
                        .clickable {
                            uiState.onTogglePasswordVisibility()
                        }

                    when (uiState.isShowPassword) {
                        true -> Icon(
                            imageVector = Icons.Default.Visibility,
                            contentDescription = null,
                            trailingIconModifier
                        )

                        false -> Icon(
                            imageVector = Icons.Default.VisibilityOff,
                            contentDescription = null,
                            trailingIconModifier
                        )
                    }
                },
                visualTransformation =
                when (uiState.isShowPassword) {
                    true -> VisualTransformation.None
                    false -> PasswordVisualTransformation()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 8.dp)
            )
            Button(
                onClick = { onSignIn() },
                modifier = Modifier
                    .padding(top = 16.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(text = stringResource(id = R.string.button_signIn))
            }
            Button(
                onClick = { navigateToSignUp() },
                modifier = Modifier
                    .padding(top = 16.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(text = stringResource(id = R.string.button_signUp))
            }
        }
    }
}

@Preview(name = "default")
@Composable
fun SignInPreview() {
    SignIn(onSignIn = {}, uiState = SignInUiState(), navigateToSignUp = {})
}

@Preview(name = "with error")
@Composable
fun SignInErrorPreview() {
    SignIn(
        onSignIn = {},
        navigateToSignUp = {},
        uiState = SignInUiState(
            error = "Error"
        )
    )
}