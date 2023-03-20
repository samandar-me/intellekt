package com.sdk.tafakkur.ui.auth.login

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.sdk.tafakkur.R
import com.sdk.tafakkur.ui.auth.register.LoadingBar
import com.sdk.tafakkur.ui.components.AppTextField
import com.sdk.tafakkur.ui.theme.Blue
import com.sdk.tafakkur.ui.theme.RobotBold
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(
    navController: NavController,
) {
    var isBtnVisible by remember {
        mutableStateOf(true)
    }
    val scope = rememberCoroutineScope()
    Column(
        modifier = Modifier
            .fillMaxSize()
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
        AppTextField(text = "", hint = "Email", onValueChange = { })
        AppTextField(text = "", hint = "Parol", onValueChange = { })
        Box(
            modifier = Modifier.fillMaxWidth().height(55.dp),
            contentAlignment = Alignment.Center
        ) {
            this@Column.AnimatedVisibility(
                visible = isBtnVisible,
                exit = fadeOut(),
                enter = fadeIn()
            ) {
                ElevatedButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(55.dp),
                    onClick = {
                        isBtnVisible = false
                        scope.launch {
                            delay(2000L)
                            isBtnVisible = true
                        }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Blue)
                ) {
                    Text(
                        text = stringResource(id = R.string.intro),
                        color = Color.White,
                        fontSize = 17.sp,
                        fontFamily = RobotBold
                    )
                }
            }
            this@Column.AnimatedVisibility(
                visible = !isBtnVisible,
                exit = fadeOut(),
                enter = fadeIn()
            ) {
                LoadingBar()
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = stringResource(id = R.string.acc_there), fontSize = 13.sp)
            Spacer(modifier = Modifier.width(10.dp))
            TextButton(onClick = { /*TODO*/ }) {
                Text(text = stringResource(id = R.string.register), fontSize = 13.sp, color = Blue)
            }
        }
    }
}