package chang.app

import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureComposeAndroid() {

    with(pluginManager) {
        apply("org.jetbrains.kotlin.plugin.compose")
    }

    androidExtension.apply {
        buildFeatures {
            compose = true
        }

        val libs = versionCatalog
        dependencies {
//            implementation(libs.findBundle("androidX-compose"))
//            debugImplementation(libs.findBundle("androidX-compose-debug"))
            val bom = libs.findLibrary("compose.bom").get()
            add("implementation", platform(bom))
            add("androidTestImplementation", platform(bom))
            add("implementation", libs.findBundle("compose").get())
        }
    }
}