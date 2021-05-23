object AppVersion {
    const val appMajorVersion = 1
    const val appMinorVersion = 1
    const val appHotfixVersion = 0
    const val appIterationVersion = 0

    const val APPLICATION_VERSION_CODE = appMajorVersion * 1_000_000 +
            appMinorVersion * 10_000 +
            appHotfixVersion * 100 +
            appIterationVersion

    const val APPLICATION_VERSION_NAME =
        "$appMajorVersion.$appMinorVersion.$appHotfixVersion"

}

object SdkVersion {
    const val compile = 30
    const val target = compile
    const val minSdk = 23
    const val buildTool = "30.0.3"
}

object LibraryVersion {

    const val kotlin = "1.4.32"
    const val gradle = "7.0.0-alpha15"

    //androidX
    const val coreKTX = "1.3.2"
    const val appcompat = "1.2.0"
    const val lifecycleRuntime = "2.3.1"

    //ui
    const val material = "1.3.0"
    const val insets = "0.9.1"
    const val systemUiController = "0.9.0"

    //compose
    const val compose = "1.0.0-beta05"
    const val composeActivity = "1.3.0-alpha07"

    //image
    const val glide = "4.12.0"
    const val lottie ="3.6.1"

    //network
    const val retrofit ="2.9.0"
    const val moshi = "1.12.0"
    const val okhttp ="4.9.0"

    //test
    const val junit = "4.13.2"
    const val junit_ext = "1.1.2"
    const val espresso = " 3.3.0"

    //di
    const val hilt = "2.33-beta"
    const val hiltJetpack = "1.0.0-alpha01"
    const val hiltNavigation ="1.0.0-alpha03"

    //util
    const val  timber = "4.7.1"
}


object Library {


    //kotlin
    const val kotlinLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${LibraryVersion.kotlin}"

    //androidx
    const val core = "androidx.core:core-ktx:${LibraryVersion.coreKTX}"
    const val appcompat = "androidx.appcompat:appcompat:${LibraryVersion.appcompat}"
    const val lifecycleRunTime = "androidx.lifecycle:lifecycle-runtime-ktx:${LibraryVersion.lifecycleRuntime}"

    //compose
    const val composeUI = "androidx.compose.ui:ui:$${LibraryVersion.compose}"
    const val composeTooling = "androidx.compose.ui:ui-tooling:${LibraryVersion.compose}"
    const val composeFoundation = "androidx.compose.foundation:foundation:${LibraryVersion.compose}"
    const val composeMaterial = "androidx.compose.material:material:${LibraryVersion.compose}"
    const val composeMaterialIconCore = "androidx.compose.material:material-icons-core:${LibraryVersion.compose}"
    const val composeMaterialIconExtension = "androidx.compose.material:material-icons-extended:${LibraryVersion.compose}"
    const val composeLiveData = "androidx.compose.runtime:runtime-livedata:${LibraryVersion.compose}"
    const val composeRxJava = "androidx.compose.runtime:runtime-rxjava2:${LibraryVersion.compose}"
    const val composeActivity = "androidx.activity:activity-compose:${LibraryVersion.composeActivity}"
    const val composeViewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha02"
    const val composeNavigation = "androidx.navigation:navigation-compose:1.0.0-alpha10"
    const val composeHiltNavigation = "androidx.hilt:hilt-navigation-compose:1.0.0-alpha01"
    const val composeConstraintlayout = "androidx.constraintlayout:constraintlayout-compose:1.0.0-alpha03"

    //ui
    const val material = "com.google.android.material:material:${LibraryVersion.material}"
    const val insets = "com.google.accompanist:accompanist-insets:${LibraryVersion.insets}"
    const val systemUiController = "com.google.accompanist:accompanist-systemuicontroller:${LibraryVersion.systemUiController}"

    //image
    const val glide = "com.github.bumptech.glide:glide:${LibraryVersion.glide}"
    const val glideOkHttpIntegration = "com.github.bumptech.glide:okhttp3-integration:${LibraryVersion.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${LibraryVersion.glide}"
    const val lottie = "com.airbnb.android:lottie:${LibraryVersion.lottie}"

    //network
    const val retrofit = "com.squareup.retrofit2:retrofit:${LibraryVersion.retrofit}"
    const val retrofitConverterMoshi = "com.squareup.retrofit2:converter-moshi:${LibraryVersion.retrofit}"
    const val okhttp = "com.squareup.okhttp3:okhttp:${LibraryVersion.okhttp}}"
    const val okhttpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${LibraryVersion.okhttp}"

    //util
    const val timber = "com.jakewharton.timber:timber:${LibraryVersion.timber}"
    const val moshi = "com.squareup.moshi:moshi:${LibraryVersion.moshi}"

    //test
    const val junit = "junit:junit:${LibraryVersion.junit}"
    const val junitExt = "androidx.test.ext:junit:${LibraryVersion.junit_ext}"
    const val espresso = "androidx.test.espresso:espresso-core:${LibraryVersion.espresso}"

    //hilt
    const val hilt = "com.google.dagger:hilt-android:${LibraryVersion.hilt}"
    const val hiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:${LibraryVersion.hilt}"
    const val hiltViewModel = "androidx.hilt:hilt-lifecycle-viewmodel:${LibraryVersion.hiltJetpack}"
    const val hiltJecPackCompiler = "androidx.hilt:hilt-compiler:${LibraryVersion.hiltJetpack}"
    const val hiltNavigation = "androidx.hilt:hilt-navigation-fragment:${LibraryVersion.hiltNavigation}"

}