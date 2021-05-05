plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = SdkVersion.compile
    buildToolsVersion =  SdkVersion.buildTool

    defaultConfig {
        applicationId = "com.mmm.icecrush"
        minSdk = SdkVersion.minSdk
        targetSdk = SdkVersion.target
        versionCode = AppVersion.APPLICATION_VERSION_CODE
        versionName = AppVersion.APPLICATION_VERSION_NAME

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
        useIR = true
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = LibraryVersion.compose
        kotlinCompilerVersion = LibraryVersion.kotlin
    }
}

dependencies {

    moduleLib()
    kotlinLib()
    androidX()
    ui()
    network()
    compose()
    image()
    util()
    test()
    di()

}