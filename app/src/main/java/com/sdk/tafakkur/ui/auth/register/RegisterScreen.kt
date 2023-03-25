package com.sdk.tafakkur.ui.auth.register

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.sdk.tafakkur.R
import com.sdk.tafakkur.ui.components.*
import com.sdk.tafakkur.ui.theme.Blue
import com.sdk.tafakkur.util.Graph
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(
    navController: NavController,
    viewModel: RegisterViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    LaunchedEffect(key1 = state.successBarVisible) {
        if (state.successBarVisible) {
            delay(1000L)
            navController.navigate(Graph.MAIN) {
                popUpTo(Graph.AUTH) {
                    inclusive = true
                }
            }
        }
    }
    Scaffold() { paddingValues ->
        AnimatedMessageBar(
            isVisible = state.successBarVisible
        ) {
            SuccessMessageBar(text = state.message)
        }
        AnimatedMessageBar(
            isVisible = state.errorBarVisible
        ) {
            ErrorMessageBar(text = state.message)
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(25.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Image(
                painter = painterResource(id = R.drawable.register_acc),
                contentDescription = "register",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(110.dp)
            )
            ImagePicker(
                onSuccess = viewModel::onImageChange
            )
            AppTextField(
                text = state.fullName,
                hint = "Ism",
                onValueChange = viewModel::onFullNameChange
            )
            AppTextField(
                text = state.email,
                hint = "Email",
                onValueChange = viewModel::onUserNameChange
            )
            PasswordTextField(
                text = state.password,
                hint = "Parol",
                onValueChange = viewModel::onPasswordChange
            )
            LoadingButton(
                isLoading = state.isLoading,
                textId = R.string.register,
                onClick = viewModel::register
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = stringResource(id = R.string.already_have_acc), fontSize = 13.sp)
                Spacer(modifier = Modifier.width(10.dp))
                TextButton(onClick = {
                    navController.popBackStack()
                }) {
                    Text(text = stringResource(id = R.string.intro), fontSize = 13.sp, color = Blue)
                }
            }
        }
    }
}