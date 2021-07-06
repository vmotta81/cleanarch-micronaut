plugins {
    id("io.micronaut.library") version "2.0.0"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.4.32"
}
dependencies {
    implementation("io.micronaut:micronaut-core:2.5.7")
    implementation("io.micronaut.data:micronaut-data-hibernate-jpa:2.4.6")

    implementation("br.com.caelum.stella:caelum-stella-core:2.1.4")

    implementation(project(":entities"))
    implementation(project(":usecases"))
}