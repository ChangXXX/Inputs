plugins {
    alias(libs.plugins.inputs.android.library)
    alias(libs.plugins.inputs.android.coroutine)
    alias(libs.plugins.inputs.android.hilt)
}

android {
    namespace = "git.changxxx.core.data"
}

dependencies {
    implementation(project(":core:androidutil"))
    implementation(project(":core:domain"))
}