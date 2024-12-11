package chang.app

import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureHiltAndroid() {

    with(pluginManager) {
        apply("com.google.devtools.ksp")
        apply("dagger.hilt.android.plugin")
    }

    val libs = versionCatalog

    dependencies {
        add("implementation", libs.findLibrary("hilt.android").get())
        add("ksp", libs.findLibrary("hilt.compiler").get())
    }
}