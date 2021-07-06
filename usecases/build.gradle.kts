plugins {
    id("io.micronaut.library") version "2.0.0"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.4.32"
}
dependencies {
    implementation("javax.inject:javax.inject:1")

    implementation(project(":entities"))
}