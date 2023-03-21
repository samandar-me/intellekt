package com.sdk.tafakkur.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.sdk.data.repository.AuthRepositoryImpl
import com.sdk.domain.repository.AuthRepository
import com.sdk.domain.use_case.auth.LoginUseCase
import com.sdk.domain.use_case.auth.RegisterUseCase
import com.sdk.domain.use_case.base.UseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @[Provides Singleton]
    fun provideFirebaseAuth(): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }

    @[Provides Singleton]
    fun provideFirebaseStorage(): FirebaseStorage {
        return FirebaseStorage.getInstance()
    }

    @[Provides Singleton]
    fun provideFirebaseFireStore(): FirebaseFirestore {
        return FirebaseFirestore.getInstance()
    }

    @[Provides Singleton]
    fun provideAuthRepository(
        auth: FirebaseAuth,
        storage: FirebaseStorage,
        fireStore: FirebaseFirestore,
    ): AuthRepository {
        return AuthRepositoryImpl(
            auth, storage, fireStore
        )
    }
    @[Provides Singleton]
    fun provideUseCases(authRepository: AuthRepository): UseCases {
        return UseCases(
            loginUseCase = LoginUseCase(authRepository),
            registerUseCase = RegisterUseCase(authRepository)
        )
    }
}