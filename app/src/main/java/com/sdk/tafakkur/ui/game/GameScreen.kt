package com.sdk.tafakkur.ui.game

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.sdk.tafakkur.ui.components.OptionItem
import com.sdk.tafakkur.ui.theme.Correct
import com.sdk.tafakkur.ui.theme.InCorrect
import com.sdk.tafakkur.ui.theme.RobotBold

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameScreen(navHostController: NavHostController) {
    val viewModel: GameViewModel = hiltViewModel()
    val state by viewModel.gameState.collectAsState()
    val scope = rememberCoroutineScope()
    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        CenterAlignedTopAppBar(colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.Transparent
        ),
            title = {
                Text(text = state.currentQuestionNumber.toString())
            },
            navigationIcon = {
                IconButton(onClick = { navHostController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowLeft,
                        contentDescription = "back"
                    )
                }
            })
    }) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp, bottom = 20.dp, top = 15.dp)
                    .weight(1f),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.onTertiaryContainer),
                shape = RoundedCornerShape(8.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(5.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = state.currentQuestion,
                        fontFamily = RobotBold,
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp)
                    .weight(2f),
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                items(state.options) {
                    if (!state.isEnabled) {
                        if (state.correct == it)
                            OptionItem(
                            onClick = viewModel::loadNextQuestion,
                            text = it,
                            isEnabled = false,
                            color = Correct
                        )
                        else
                            OptionItem(
                                onClick = viewModel::loadNextQuestion,
                                text = it,
                                isEnabled = false,
                                color = InCorrect
                            )
                    } else
                        OptionItem(
                            onClick = viewModel::loadNextQuestion,
                            text = it,
                            isEnabled = true,
                            color = MaterialTheme.colorScheme.surfaceVariant
                        )
                }
            }
        }
    }
}