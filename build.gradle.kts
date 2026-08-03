plugins {
    kotlin("jvm") version "2.4.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://snapshots.kord.dev")
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("net.dv8tion:JDA:6.5.0")
    implementation("io.github.cdimascio:dotenv-kotlin:6.4.1")
    implementation("ch.qos.logback:logback-classic:1.5.6")
}

kotlin {
    jvmToolchain(26)
}

tasks.test {
    useJUnitPlatform()
}