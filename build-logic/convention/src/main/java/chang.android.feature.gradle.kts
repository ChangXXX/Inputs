import chang.app.configureCoroutineAndroid
import chang.app.versionCatalog

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

val libs = versionCatalog

dependencies {
    add("implementation", project(":core:designsystem"))
    add("implementation", project(":core:domain"))
    add("implementation", libs.findLibrary("hilt.navigation.compose").get())
    add("implementation", libs.findLibrary("timber").get())
}

configureCoroutineAndroid()