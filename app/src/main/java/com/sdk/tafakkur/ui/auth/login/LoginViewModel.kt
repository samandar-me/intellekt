package com.sdk.tafakkur.ui.auth.login

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sdk.domain.model.Login
import com.sdk.domain.use_case.base.UseCases
import com.sdk.tafakkur.util.customCombine
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val useCases: UseCases
) : ViewModel() {
    private val email = savedStateHandle.getStateFlow("email", "")
    private val password = savedStateHandle.getStateFlow("password", "")
    private val isLoading = savedStateHandle.getStateFlow("isLoading", false)
    private val message = savedStateHandle.getStateFlow("message", "")
    private val errorBar = savedStateHandle.getStateFlow("errorBar", false)
    private val successBar = savedStateHandle.getStateFlow("successBar", false)

    val state = customCombine(
        email,
        password,
        isLoading,
        message,
        errorBar,
        successBar
    ) { email, pass, isL, msg, error, success ->
        LoginState(
            isLoading = isL,
            email = email,
            password = pass,
            message = msg,
            errorBarVisible = error,
            successBarVisible = success
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(4000L), LoginState())

    fun onUserNameChanged(text: String) {
        savedStateHandle["email"] = text
    }

    fun onPasswordChanged(text: String) {
        savedStateHandle["password"] = text
    }

    fun login() {
        viewModelScope.launch {
            useCases.loginUseCase(
                Login(
                    email.value,
                    password.value
                )
            ).onStart {
                savedStateHandle["isLoading"] = true
            }.catch {
                savedStateHandle["isLoading"] = false
                savedStateHandle["message"] = "Bunday foydalanuvchi topilmadi!"
                savedStateHandle["errorBar"] = true
                delay(3000L)
                savedStateHandle["errorBar"] = false
            }.collect {
                savedStateHandle["isLoading"] = false
                if (it) {
                    savedStateHandle["successBar"] = true
                    savedStateHandle["message"] = "Muvaffaqqiyatli kirildi"
                } else {
                    savedStateHandle["message"] = "Xatolik yuz berdi."
                    savedStateHandle["errorBar"] = true
                    delay(3000L)
                    savedStateHandle["errorBar"] = false
                }
            }
        }
    }
}