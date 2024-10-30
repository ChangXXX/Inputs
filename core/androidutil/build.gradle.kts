plugins {
    alias(libs.plugins.inputs.android.library)
    alias(libs.plugins.inputs.android.compose.library)
    alias(libs.plugins.inputs.android.coroutine)
}

android {
    namespace = "git.changxxx.core.androidutil"
}

dependencies {

    implementation(libs.navigation.compose)
}