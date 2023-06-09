object Dependencies {
    const val ComposeNavigation = "androidx.navigation:navigation-compose:${Versions.navigation}"
    const val KotlinCore = "androidx.core:core-ktx:${Versions.kotlinVersion}"
    const val AndroidLifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifeVer}"
    const val AndroidComp = "androidx.activity:activity-compose:${Versions.composeVersion}"
    const val CompUi = "androidx.compose.ui:ui:${Versions.compVer}"
    const val CompToolPrev = "androidx.compose.ui:ui-tooling-preview:${Versions.compVer}"
    const val M3 = "androidx.compose.material3:material3:${Versions.m3}"
    const val FireAuth = "com.google.firebase:firebase-auth-ktx:${Versions.fireVer}"
    const val JUnit = "junit:junit:${Versions.jUnit}"
    const val AndroidJUnit = "androidx.test.ext:junit:${Versions.androidJUnit}"
    const val Espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val AndroidXUIJunit = "androidx.compose.ui:ui-test-junit4:${Versions.compVer}"
    const val UiTooling = "androidx.compose.ui:ui-tooling:${Versions.compVer}"
    const val TestManifest = "androidx.compose.ui:ui-test-manifest:${Versions.compVer}"
    const val FireCompile = "com.google.gms:google-services:${Versions.fireCompile}"
    const val DaggerHilt = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"

    const val Coil = "io.coil-kt:coil:${Versions.coil}"
    const val AccCoil = "com.google.accompanist:accompanist-coil:${Versions.accCoil}"

    const val Hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val KaptHilt = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    const val HiltVM = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hiltVm}"
    const val CompHilt = "androidx.hilt:hilt-compiler:${Versions.compHilt}"
    const val HiltNavigation = "androidx.hilt:hilt-navigation-compose:${Versions.compHilt}"
    const val RoomRun = "androidx.room:room-runtime:${Versions.room}"
    const val RoomKtx = "androidx.room:room-ktx:${Versions.room}"
    const val RoomAn = "androidx.room:room-compiler:${Versions.room}"
    const val RoomComp = "androidx.room:room-compiler:${Versions.room}"
    const val DataStore = "androidx.datastore:datastore-preferences:${Versions.compHilt}"

    const val Coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutine}"
    const val AndroidCoroutine =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutine}"
    const val LifecycleScope = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.scope}"
    const val RuntimeScope = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.scope}"

    const val FireStore = "com.google.firebase:firebase-firestore-ktx:${Versions.fireStore}"
    const val FireStorage = "com.google.firebase:firebase-storage-ktx:${Versions.fireStorage}"
    const val FireServices = "com.google.gms:google-services:${Versions.fireCompile}"
}

object Versions {
    const val hilt = "2.40.5"
    const val navigation = "2.6.0-alpha04"
    const val kotlinVersion = "1.7.0"
    const val lifeVer = "2.3.1"
    const val composeVersion = "1.1.1"
    const val compVer = "1.2.0"
    const val m3 = "1.0.0-alpha11"
    const val fireVer = "21.1.0"
    const val fireStorage = "20.1.0"
    const val fireStore = "24.4.4"
    const val jUnit = "4.13.2"
    const val androidJUnit = "1.1.5"
    const val espresso = "3.5.1"
    const val fireCompile = "4.3.15"

    const val coroutine = "1.6.4"
    const val scope = "2.5.1"

    const val hiltVm = "1.0.0-alpha03"
    const val compHilt = "1.0.0"
    const val room = "2.4.3"

    const val coil = "1.4.0"
    const val accCoil = "0.10.0"
}