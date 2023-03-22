package com.sdk.tafakkur.ui.auth.register

import android.net.Uri
import android.util.Log
import android.util.Patterns
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sdk.domain.model.Register
import com.sdk.domain.use_case.base.UseCases
import com.sdk.tafakkur.util.MSG_BAR_DELAY_TIME
import com.sdk.tafakkur.util.customCombine
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val useCases: UseCases
): ViewModel() {
    private val fullName = savedStateHandle.getStateFlow("fullName", "")
    private val email = savedStateHandle.getStateFlow("email","")
    private val password = savedStateHandle.getStateFlow("password", "")
    private val isLoading = savedStateHandle.getStateFlow("isLoading", false)
    private val message = savedStateHandle.getStateFlow("message", "")
    private val image = savedStateHandle.getStateFlow<Uri?>("image", null)
    private val errorBar = savedStateHandle.getStateFlow("errorBar", false)
    private val successBar = savedStateHandle.getStateFlow("successBar", false)

    val state = customCombine(
        fullName,
        email,
        password,
        isLoading,
        message,
        errorBar,
        successBar,
        image
    ) { fName, email, pass, isL,msg, err, success, image ->
        RegisterState(
            fullName = fName,
            email = email,
            password = pass,
            isLoading = isL,
            message = msg,
            errorBarVisible = err,
            successBarVisible = success,
            image = image
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(4000L), RegisterState())

    fun onFullNameChange(text: String) {
        savedStateHandle["fullName"] = text
    }
    fun onUserNameChange(text: String) {
        savedStateHandle["email"] = text
    }
    fun onPasswordChange(text: String) {
        savedStateHandle["password"] = text
    }
    fun onImageChange(uri: Uri?) {
        savedStateHandle["image"] = uri
    }
    fun register() {
        viewModelScope.launch {
            if (!Patterns.EMAIL_ADDRESS.matcher(email.value).matches()) {
                savedStateHandle["message"] = "Email mos emas!"
                savedStateHandle["errorBar"] = true
                delay(MSG_BAR_DELAY_TIME)
                savedStateHandle["errorBar"] = false
                return@launch
            }
            if (password.value.length < 6) {
                savedStateHandle["message"] = "Parol uzunligi 6 dan ko'p bo'lishi kerak!"
                savedStateHandle["errorBar"] = true
                delay(MSG_BAR_DELAY_TIME)
                savedStateHandle["errorBar"] = false
                return@launch
            }
            useCases.registerUseCase(
                Register(
                    fullName.value,
                    email.value,
                    image.value,
                    password.value
                )
            ).onStart {
                savedStateHandle["isLoading"] = true
            }.catch {
                savedStateHandle["isLoading"] = false
                savedStateHandle["message"] = "Bunday foydalanuvchi allaqachon yaratilgan."
                savedStateHandle["errorBar"] = true
                delay(MSG_BAR_DELAY_TIME)
                savedStateHandle["errorBar"] = false
            }.collect {
                savedStateHandle["isLoading"] = false
                if (it) {
                    useCases.changeUseAuthStateUseCase(true)
                    savedStateHandle["successBar"] = true
                    savedStateHandle["message"] = "Muvaffaqiyatli"
                }
            }
        }
    }
}