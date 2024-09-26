package com.example.animes.presentation.signup

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.animes.R
import com.example.animes.presentation.signin.SignIn
import com.example.animes.presentation.signin.SignInUiState
import com.google.common.io.Resources.getResource

@Composable
fun SignUp(
    uiState: SignUpUiState,
    onSignUp: () -> Unit
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(MaterialTheme.colorScheme.primary)
            .padding(24.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {
        AnimatedVisibility(visible = uiState.error != null,
            modifier = Modifier.background(MaterialTheme.colorScheme.error)) {
            uiState.error?.let {
                Text(text = it, fontSize = 20.sp, modifier = Modifier.fillMaxWidth().padding(8.dp))
            }
        }
        Text(text = "SignUp", fontSize = 20.sp)
        TextField(
            label = { Text("name") },
            leadingIcon = {
                Icon(
                    Icons.Default.Person,
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
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 8.dp)
        )
        Button(
            onClick = { onSignUp() },
            modifier = Modifier
                .padding(top = 16.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text(text = stringResource(R.string.button_signUp))
        }
    }
}

@Preview(name = "default")
@Composable
fun SignUpPreview() {
    SignUp(onSignUp = {}, uiState = SignUpUiState())
}
