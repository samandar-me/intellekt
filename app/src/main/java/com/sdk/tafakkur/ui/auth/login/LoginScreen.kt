package com.sdk.tafakkur.ui.auth.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()
    LaunchedEffect(key1 = state.successBarVisible) {
        if (state.successBarVisible) {
            delay(1000L)
            navController.navigate(Graph.MAIN) {
                popUpTo("login") {
                    inclusive = true
                }
            }
        }
    }
    Scaffold { paddingValues ->
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
                .verticalScroll(rememberScrollState())
                .padding(paddingValues)
                .padding(25.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Image(
                painter = painterResource(id = R.drawable.login_acc),
                contentDescription = "login",
                modifier = Modifier
                    .size(170.dp)
            )
            AppTextField(
                text = state.email,
                hint = "Email",
                onValueChange = viewModel::onUserNameChanged
            )
            Column {
                PasswordTextField(
                    text = state.password,
                    hint = "Parol",
                    onValueChange = viewModel::onPasswordChanged
                )
                Spacer(modifier = Modifier.height(2.dp))
                TextButton(onClick = { }, modifier = Modifier.align(Alignment.End)) {
                    Text(
                        text = stringResource(id = R.string.forgot_pass),
                        fontSize = 13.sp,
                        color = Blue
                    )
                }
            }
            LoadingButton(
                isLoading = state.isLoading,
                textId = R.string.intro,
                onClick = viewModel::login
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = stringResource(id = R.string.acc_there_no), fontSize = 13.sp)
                Spacer(modifier = Modifier.width(10.dp))
                TextButton(onClick = {
                    navController.navigate("register")
                }) {
                    Text(text = stringResource(id = R.string.register), fontSize = 13.sp, color = Blue)
                }
            }
        }
    }
}