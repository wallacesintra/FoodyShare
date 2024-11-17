package com.wallace.foodycare.authentication.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.wallace.foodycare.authentication.domain.events.LoginEvent
import com.wallace.foodycare.authentication.domain.viewmodels.LoginViewModel
import com.wallace.foodycare.core.presentation.common.AppButton
import com.wallace.foodycare.core.presentation.common.AppTextField
import foodycare.composeapp.generated.resources.Res
import foodycare.composeapp.generated.resources.visibility_24dp_fill0_wght400_grad0_opsz24
import foodycare.composeapp.generated.resources.visibility_off_24dp_fill0_wght400_grad0_opsz24
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier
){
    val loginViewModel = koinViewModel<LoginViewModel>()
    val loginForm = loginViewModel.loginFormState

    var passwordVisible by remember { mutableStateOf(false) }


    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .padding(8.dp)
                .widthIn(max = 400.dp)
        ) {

            Text(
                text = "FoodyShare",
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
            )

            Text(
                text = "Sign In",
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
            )

            AppTextField(
                label = "Email",
                value = loginForm.email,
                onValueChange = {
                    loginViewModel.onLoginEvent(
                        LoginEvent.EmailChange(it)
                    )
                },
                placeholder = "Email",
                keyboardType = KeyboardType.Text,
                error = loginForm.emailError,
                modifier = Modifier
                    .fillMaxWidth()
            )
            AppTextField(
                label = "Password",
                value = loginForm.password,
                onValueChange = {
                    loginViewModel.onLoginEvent(
                        LoginEvent.PasswordChange(it)
                    )
                },
                placeholder = "Password",
                error = loginForm.passwordError,
                keyboardType = KeyboardType.Password,
                passwordVisible = passwordVisible,
                trailingIcon = {
                    IconButton(
                        onClick = {
                            if (loginForm.password.isNotBlank()) {
                                passwordVisible = !passwordVisible
                            }
                        },
                        content = {
                            Icon(
                                painter = painterResource(if (!passwordVisible) Res.drawable.visibility_24dp_fill0_wght400_grad0_opsz24 else Res.drawable.visibility_off_24dp_fill0_wght400_grad0_opsz24),
//                                imageVector = Icons.Default.Email,
                                contentDescription = null,
                            )
                        }
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
            )

            AppButton(
                onClick = {
                    loginViewModel.onLoginEvent(
                        event = LoginEvent.Login
                    )
                },
                content = {
                    Text(
                        text = "Sign In"
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}