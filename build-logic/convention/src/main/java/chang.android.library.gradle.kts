
import chang.app.configureKotlinAndroid
import chang.app.versionCatalog

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

configureKotlinAndroid()

dependencies {
    add("implementation", versionCatalog.findLibrary("kotlinx.serialization.json").get())
}