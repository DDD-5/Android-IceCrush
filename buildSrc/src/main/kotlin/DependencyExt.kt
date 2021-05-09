import org.gradle.api.Project
import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.dependencies

fun DependencyHandler.implementation(dependencyNotation: Any): Dependency? =
    add("implementation", dependencyNotation)

fun DependencyHandler.testImplementation(dependencyNotation: Any): Dependency? =
    add("testImplementation", dependencyNotation)

fun DependencyHandler.androidTestImplementation(dependencyNotation: Any): Dependency? =
    add("androidTestImplementation", dependencyNotation)


fun Project.androidX() {
    dependencies {
        implementation(Library.core)
        implementation(Library.appcompat)
        implementation(Library.lifecycleRunTime)
    }
}

fun Project.ui() {
    dependencies {
        implementation(Library.material)
    }
}

fun Project.kotlinLib() {
    dependencies {
        implementation(Library.kotlinLib)
    }
}

fun Project.moduleLib(){
    dependencies {
        implementation(project(":data"))
        implementation(project(":model"))
    }
}


fun Project.compose() {
    dependencies {
        implementation(Library.composeUI)
        implementation(Library.composeTooling)
        implementation(Library.composeFoundation)
        implementation(Library.composeMaterialIconCore)
        implementation(Library.composeMaterialIconExtension)
        implementation(Library.composeLiveData)
        implementation(Library.composeRxJava)
        implementation(Library.composeActivity)
        implementation(Library.composeMaterial)
        implementation(Library.composeViewModel)
        implementation(Library.composeHiltNavigation)
    }
}

fun Project.image() {
    dependencies {
        implementation(Library.glide)
        implementation(Library.glideOkHttpIntegration)
        implementation(Library.lottie)
        "kapt"(Library.glideCompiler)
    }
}

fun Project.network() {
    dependencies {
        implementation(Library.retrofit)
        implementation(Library.retrofitConverterMoshi)
        implementation(Library.okhttp)
        implementation(Library.okhttpLoggingInterceptor)
    }
}

fun Project.util() {
    dependencies {
        implementation(Library.timber)
        implementation(Library.moshi)
    }
}

fun Project.di() {
    dependencies {
        implementation(Library.hilt)
        implementation(Library.hiltNavigation)
        implementation(Library.hiltViewModel)
        "kapt"(Library.hiltAndroidCompiler)
        "kapt"(Library.hiltJecPackCompiler)
    }
}


fun Project.test() {
    dependencies {
        testImplementation(Library.junit)
        androidTestImplementation(Library.espresso)
        androidTestImplementation(Library.junitExt)
    }
}
