plugins {
    kotlin("jvm") version "2.1.20"
}

group = "com.sesac.healthcare"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlin:kotlin-reflect:2.1.20")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}