import chang.app.configureCoroutineAndroid
import chang.app.versionCatalog

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}


val libs = versionCatalog

dependencies {
    add("implementation", project(":core:designsystem"))
//    add("implementation", project(":"))

    add("implementation", libs.findLibrary("timber").get())
}

configureCoroutineAndroid()