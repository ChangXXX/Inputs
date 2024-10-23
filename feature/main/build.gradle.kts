plugins {
    alias(libs.plugins.inputs.android.library)
    alias(libs.plugins.inputs.android.compose.library)
    alias(libs.plugins.inputs.android.hilt)
    alias(libs.plugins.inputs.android.feature)
}

android {
    namespace = "git.changxxx.feature.note"
}

dependencies {

    implementation(project(":core:designsystem"))
    implementation(project(":core:navigation"))
    implementation(project(":feature:note"))
    implementation(project(":feature:notedetail"))
    implementation(project(":feature:write"))

    implementation(libs.activity.compose)
    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
}