package com.sdk.tafakkur.di

import android.content.Context
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.sdk.data.manager.DataStoreManager
import com.sdk.data.repository.AuthRepositoryImpl
import com.sdk.data.repository.MainRepositoryImpl
import com.sdk.domain.repository.AuthRepository
import com.sdk.domain.repository.MainRepository
import com.sdk.domain.use_case.auth.ChangeUseAuthStateUseCase
import com.sdk.domain.use_case.auth.LoginUseCase
import com.sdk.domain.use_case.auth.RegisterUseCase
import com.sdk.domain.use_case.base.UseCases
import com.sdk.domain.use_case.main.GetQuestionListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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
        manager: DataStoreManager
    ): AuthRepository {
        return AuthRepositoryImpl(
            auth, storage, fireStore, manager
        )
    }

    @[Provides Singleton]
    fun provideMainRepository(
        fireStore: FirebaseFirestore
    ): MainRepository {
        return MainRepositoryImpl(fireStore)
    }

    @[Provides Singleton]
    fun provideDataStoreManager(@ApplicationContext context: Context): DataStoreManager {
        return DataStoreManager(context)
    }
    @[Provides Singleton]
    fun provideUseCases(
        authRepository: AuthRepository,
        mainRepository: MainRepository
    ): UseCases {
        return UseCases(
            loginUseCase = LoginUseCase(authRepository),
            registerUseCase = RegisterUseCase(authRepository),
            changeUseAuthStateUseCase = ChangeUseAuthStateUseCase(authRepository),
            getQuestionListUseCase = GetQuestionListUseCase(mainRepository)
        )
    }
}