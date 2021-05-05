// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {

    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:${LibraryVersion.gradle}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${LibraryVersion.kotlin}")
        classpath("com.google.dagger:hilt-android-gradle-plugin:${LibraryVersion.hilt}")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}