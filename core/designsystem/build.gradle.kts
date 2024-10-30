plugins {
    alias(libs.plugins.inputs.android.library)
    alias(libs.plugins.inputs.android.compose.library)
}

android {
    namespace = "git.changxxx.core.designsystem"
}

dependencies {

    implementation(project(":core:androidutil"))

    implementation(libs.compose.runtime)
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.tooling)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.compose.ui.util)
    implementation(libs.compose.material3)
    implementation(libs.compose.ui.graphics)
}