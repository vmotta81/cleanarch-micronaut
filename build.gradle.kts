import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.4.32"
    id("org.jetbrains.kotlin.kapt") version "1.4.32"
}

allprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "org.jetbrains.kotlin.kapt")

    repositories {
        mavenCentral()
    }

    dependencies {
        implementation("org.jetbrains.kotlin:kotlin-reflect:1.4.32")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.4.32")
    }

    tasks.withType<Test> { useJUnitPlatform() }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            allWarningsAsErrors = true
            jvmTarget = "11"
        }
    }
}