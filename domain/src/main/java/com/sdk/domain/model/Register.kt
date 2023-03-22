package com.sdk.domain.model

import android.net.Uri
import java.io.File

data class Register(
    val fullName: String,
    val email: String,
    val image: Uri? = null,
    val password: String
)