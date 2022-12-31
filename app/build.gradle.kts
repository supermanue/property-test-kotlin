/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Kotlin application project to get you started.
 * For more details take a look at the 'Building Java & JVM projects' chapter in the Gradle
 * User Manual available at https://docs.gradle.org/7.6/userguide/building_java_projects.html
 * This project uses @Incubating APIs which are subject to change.
 */

plugins {
    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
    id("org.jetbrains.kotlin.jvm") version "1.7.10"

    // Apply the application plugin to add support for building a CLI application in Java.
    application
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}


dependencies {
    // This dependency is used by the application.
    implementation("com.google.guava:guava:31.1-jre")

    testImplementation("io.kotest:kotest-runner-junit5:5.5.4")
    testImplementation ("io.kotest:kotest-property:5.5.4")
    testImplementation ("io.kotest:kotest-assertions-core:5.5.4")

}

testing {
    suites {
        // Configure the built-in test suite
        val test by getting(JvmTestSuite::class) {
            // Use Kotlin Test test framework
            useKotlinTest("1.7.10")

            dependencies {
                // Use newer version of JUnit Engine for Kotlin Test
                implementation("org.junit.jupiter:junit-jupiter-engine:5.9.1")
            }
        }
    }
}

application {
    // Define the main class for the application.
    mainClass.set("property.test.kotlin.AppKt")
}
