plugins {
    id("io.micronaut.library") version "2.0.0"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.4.32"
}

dependencies {
    implementation("io.micronaut:micronaut-core:2.5.7")
    implementation("io.micronaut:micronaut-http:2.5.7")

    implementation(project(":usecases"))
}