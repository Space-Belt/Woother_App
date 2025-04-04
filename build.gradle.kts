// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
}

apply<HelloWorldPlugin>()

class HelloWorldPlugin: Plugin<Project> {
    override fun apply(targe: Project) {
        println("Hello Anroid")
    }
}