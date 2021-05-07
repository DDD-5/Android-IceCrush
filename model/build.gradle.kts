plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = SdkVersion.compile
    buildToolsVersion =  SdkVersion.buildTool

    defaultConfig {
        minSdk = SdkVersion.minSdk
        targetSdk = SdkVersion.target
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
    composeOptions {
        kotlinCompilerExtensionVersion = LibraryVersion.compose
        kotlinCompilerVersion = LibraryVersion.kotlin
    }
}

dependencies {
    kotlinLib()
    network()
    di()
    util()
    test()
}