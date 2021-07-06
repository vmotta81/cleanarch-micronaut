plugins {
    id("com.github.johnrengelman.shadow") version "7.0.0"
    id("io.micronaut.application") version "1.5.3"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.4.32"
}

group = "com.vmotta.cleanarch"
version = "1.0.0-SNAPSHOT"

micronaut {
    version("2.5.7")
    runtime("netty")
    testRuntime("junit5")
    processing {
        incremental(true)
        annotations("com.vmotta.cleanarch.*")
    }
}

dependencies {
    runtimeOnly("ch.qos.logback:logback-classic")

    implementation("io.micronaut.sql:micronaut-jdbc-hikari")
    runtimeOnly("org.postgresql:postgresql:42.2.13")

    implementation("io.micronaut.flyway:micronaut-flyway")

    implementation(project(":controllers"))
    implementation(project(":frameworks"))
}

application {
    mainClass.set("com.vmotta.cleanarch.CleanArchAppKt")
}