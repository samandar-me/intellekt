package com.sdk.domain.model

import android.net.Uri

data class Register(
    val fullName: String,
    val email: String,
    val image: Uri,
    val password: String,
    val name: String
)